package lt.techin.platform;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

final class JavaSource {

    private JavaSource() {
    }

    static String codeOnly(Path path) throws IOException {
        String source = Files.readString(path);
        StringBuilder result = new StringBuilder(source.length());
        State state = State.CODE;

        for (int index = 0; index < source.length(); index++) {
            char current = source.charAt(index);
            char next = index + 1 < source.length() ? source.charAt(index + 1) : '\0';

            switch (state) {
                case CODE -> {
                    if (current == '/' && next == '/') {
                        result.append("  ");
                        index++;
                        state = State.LINE_COMMENT;
                    } else if (current == '/' && next == '*') {
                        result.append("  ");
                        index++;
                        state = State.BLOCK_COMMENT;
                    } else if (current == '"' && source.startsWith("\"\"\"", index)) {
                        result.append("   ");
                        index += 2;
                        state = State.TEXT_BLOCK;
                    } else if (current == '"') {
                        result.append(' ');
                        state = State.STRING;
                    } else if (current == '\'') {
                        result.append(' ');
                        state = State.CHARACTER;
                    } else {
                        result.append(current);
                    }
                }
                case LINE_COMMENT -> {
                    result.append(current == '\n' ? '\n' : ' ');
                    if (current == '\n') {
                        state = State.CODE;
                    }
                }
                case BLOCK_COMMENT -> {
                    if (current == '*' && next == '/') {
                        result.append("  ");
                        index++;
                        state = State.CODE;
                    } else {
                        result.append(current == '\n' ? '\n' : ' ');
                    }
                }
                case STRING, CHARACTER -> {
                    if (current == '\\' && index + 1 < source.length()) {
                        result.append("  ");
                        index++;
                    } else {
                        result.append(current == '\n' ? '\n' : ' ');
                        if ((state == State.STRING && current == '"')
                                || (state == State.CHARACTER && current == '\'')) {
                            state = State.CODE;
                        }
                    }
                }
                case TEXT_BLOCK -> {
                    if (current == '"' && source.startsWith("\"\"\"", index)) {
                        result.append("   ");
                        index += 2;
                        state = State.CODE;
                    } else {
                        result.append(current == '\n' ? '\n' : ' ');
                    }
                }
            }
        }

        return result.toString();
    }

    private enum State {
        CODE,
        LINE_COMMENT,
        BLOCK_COMMENT,
        STRING,
        CHARACTER,
        TEXT_BLOCK
    }
}


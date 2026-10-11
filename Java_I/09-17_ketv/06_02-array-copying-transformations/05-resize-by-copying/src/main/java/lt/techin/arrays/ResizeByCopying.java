package lt.techin.arrays;

public class ResizeByCopying {
    public static int[] removeAt(int[] source, int index) {
        // TODO
        if (index < 0 || index >= source.length) {
            return null;
        }
        int[] result = new int[source.length - 1];
        System.arraycopy(source, 0, result, 0, index);
        System.arraycopy(source, index + 1, result, index, source.length - index - 1);
        return result;
    }

    public static int[] insertAt(int[] source, int position, int value) {
        // TODO
        if (position < 0 || position > source.length) {
            return null;
        }
        int[] result = new int[source.length + 1];
        System.arraycopy(source, 0, result, 0, position);
        result[position] = value;
        System.arraycopy(source, position, result, position + 1, source.length - position);
        return result;
    }
}

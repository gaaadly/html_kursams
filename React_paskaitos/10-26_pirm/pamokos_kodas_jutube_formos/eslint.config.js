import js from "@eslint/js";
import globals from "globals";
import reactHooks from "eslint-plugin-react-hooks";
import reactRefresh from "eslint-plugin-react-refresh";
import eslintConfigPrettier from "eslint-config-prettier";

export default [
  { ignores: ["dist"] },

  js.configs.recommended,

  {
    files: ["**/*.{js,jsx}"],
    languageOptions: {
      ecmaVersion: "latest",
      sourceType: "module",
      globals: globals.browser,
      parserOptions: {
        ecmaFeatures: { jsx: true },
      },
    },
    plugins: {
      "react-hooks": reactHooks,
      "react-refresh": reactRefresh,
    },
    rules: {
      // Checks the rules of hooks (e.g. useEffect dependencies)
      ...reactHooks.configs.recommended.rules,
      // Warns if a file exports something other than components
      "react-refresh/only-export-components": [
        "warn",
        { allowConstantExport: true },
      ],
      // Unused variables are errors, except names starting with a capital
      // letter (components) or _
      "no-unused-vars": ["error", { varsIgnorePattern: "^[A-Z_]" }],
    },
  },

  // Turns off ESLint formatting rules, Prettier handles formatting
  eslintConfigPrettier,
];

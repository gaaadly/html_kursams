# React Starter

Blank project for exams: Vite + React + Tailwind CSS + ESLint + Prettier.

## Use it during the exam

```bash
git clone https://github.com/YOUR-USERNAME/react-starter.git exam-project
cd exam-project
npm install
npm run dev
```

## Commands

| Command          | What it does                       |
| ---------------- | ---------------------------------- |
| `npm run dev`    | starts the app (localhost:5173)    |
| `npm run lint`   | checks the code with ESLint        |
| `npm run format` | formats all files with Prettier    |
| `npm run build`  | builds the final version to `dist` |

## What's inside

```
src/
  main.jsx        starts React
  App.jsx         blank start page
  index.css       Tailwind (@import "tailwindcss")
  components/     put your components here
public/           files served as-is (images, JSON for fetch)
eslint.config.js  ESLint rules (React hooks included)
.prettierrc       Prettier settings + Tailwind class sorting
.vscode/          format on save + recommended extensions
```

## Tailwind

No config file needed (Tailwind v4). Just use classes:

```jsx
<button className="rounded bg-blue-500 px-4 py-2 text-white hover:bg-blue-600">
  Click
</button>
```

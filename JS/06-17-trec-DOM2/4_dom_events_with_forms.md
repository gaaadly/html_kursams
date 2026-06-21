# DOM Events with Forms

*A hands-on practice pack to master form events in the browser: `input`, `change`, `submit`, `focus`, `blur`, `reset`, and clipboard events.*

---

## How to Use This Worksheet
- Each task has: **Goal**, **Events**, **Starter HTML/JS**, and **Challenges** (optional stretch goals).
- You can reuse the **Base Template** for all tasks or copy the per-task starter.
- Keep your solutions in a separate `script.js` file if you prefer. Comment your code.

---

## Base Template (reuse for tasks)
```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Form Events Practice</title>
  <style>
    .focused { outline: 2px solid #00aaff; }
    .valid { border-color: #28a745; }
    .invalid { border-color: #dc3545; }
    .hidden { display: none; }
    progress { width: 100%; height: 16px; }
    small.hint { color: #555; }
  </style>
</head>
<body>
  <h1>Form Events Practice</h1>
  <form id="form">
    <!-- Replace with each task's fields -->
  </form>
  <section id="output"></section>

  <script>
    // Your JS goes here for each task
  </script>
</body>
</html>
```

---

## 1) Live Character Counter
**Goal:** Show the number of characters typed.
**Events:** `input`

**Starter:**
```html
<label>Message
  <input id="message" type="text" placeholder="Type something" />
</label>
<p>Characters: <span id="count">0</span></p>
```
```js
const message = document.getElementById('message');
const count = document.getElementById('count');
message.addEventListener('input', () => {
  // TODO: update count.textContent with message.value length
});
```
**Challenges:** Enforce a max length and display remaining.

---

## 2) Enable Submit Button
**Goal:** Keep submit disabled until all required fields are filled.
**Events:** `input`, `change`

**Starter:**
```html
<input id="first" required placeholder="First name" />
<input id="last" required placeholder="Last name" />
<button id="submitBtn" type="submit" disabled>Submit</button>
```
```js
const requiredFields = [first, last];
const submitBtn = document.getElementById('submitBtn');
function evaluate() {
  // TODO: toggle submitBtn.disabled based on trimmed values
}
requiredFields.forEach(el => el.addEventListener('input', evaluate));
```
**Challenges:** Show per-field ✅/❌ indicators.

---

## 3) Password Match Check
**Goal:** Live check that passwords match.
**Events:** `input`

**Starter:**
```html
<input id="pass" type="password" placeholder="Password" />
<input id="confirm" type="password" placeholder="Confirm" />
<small id="matchMsg"></small>
```
```js
function checkMatch() {
  // TODO: update matchMsg text + class based on equality
}
pass.addEventListener('input', checkMatch);
confirm.addEventListener('input', checkMatch);
```
**Challenges:** Enforce min length and strength meter.

---

## 4) Focus & Blur Highlight
**Goal:** Highlight an input on focus; remove on blur.
**Events:** `focus`, `blur`

**Starter:**
```html
<input id="focusMe" placeholder="Focus me" />
```
```js
focusMe.addEventListener('focus', () => {
  // TODO: add .focused
});
focusMe.addEventListener('blur', () => {
  // TODO: remove .focused
});
```
**Challenges:** Delegate with a single listener for many inputs.

---

## 5) Prevent Empty Submit
**Goal:** Block submit if any field is empty; show a message.
**Events:** `submit`

**Starter:**
```html
<input name="email" placeholder="Email" />
<input name="name" placeholder="Name" />
<button type="submit">Send</button>
<p id="error" class="hidden">Please fill in all fields.</p>
```
```js
const form = document.getElementById('form');
form.addEventListener('submit', (e) => {
  // TODO: if any input value is empty -> e.preventDefault() and show #error
});
```
**Challenges:** Scroll to first invalid input.

---

## 6) Form Data Preview (Live)
**Goal:** Mirror input values into a preview box.
**Events:** `input`

**Starter:**
```html
<input id="title" placeholder="Title" />
<textarea id="desc" placeholder="Description"></textarea>
<h3>Preview</h3>
<p><strong id="pTitle"></strong></p>
<p id="pDesc"></p>
```
```js
[title, desc].forEach(el => el.addEventListener('input', () => {
  // TODO: set pTitle.textContent and pDesc.textContent
}));
```
**Challenges:** Preserve line breaks using `<br>`.

---

## 7) Auto Uppercase
**Goal:** Convert text to uppercase as user types.
**Events:** `input`

**Starter:**
```html
<input id="upper" placeholder="Type lowercase" />
```
```js
upper.addEventListener('input', (e) => {
  // TODO: set e.target.value = e.target.value.toUpperCase()
});
```
**Challenges:** Keep caret position stable (advanced).

---

## 8) Dynamic Email Validation
**Goal:** Validate email live; toggle valid/invalid styles.
**Events:** `input`

**Starter:**
```html
<input id="email" placeholder="Email" />
<small class="hint" id="emailHint">Enter a valid email</small>
```
```js
function isEmail(v){
  return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(v);
}
email.addEventListener('input', () => {
  // TODO: toggle classes .valid/.invalid on #email
});
```
**Challenges:** Show domain suggestions (e.g., gmail.com).

---

## 9) Confirm Form Reset
**Goal:** Confirm before resetting the form.
**Events:** `reset`

**Starter:**
```html
<button type="reset">Reset</button>
```
```js
form.addEventListener('reset', (e) => {
  // TODO: if (!confirm('Clear form?')) e.preventDefault()
});
```
**Challenges:** Custom modal instead of `confirm()`.

---

## 10) Calculate Total Price
**Goal:** Update total when price or qty changes.
**Events:** `input`, `change`

**Starter:**
```html
<input id="price" type="number" min="0" step="0.01" placeholder="Price" />
<input id="qty" type="number" min="0" step="1" placeholder="Qty" />
<p>Total: <strong id="total">0.00</strong></p>
```
```js
function updateTotal(){
  // TODO: parseFloat price * parseInt qty -> total.textContent
}
[price, qty].forEach(el => el.addEventListener('input', updateTotal));
```
**Challenges:** Format as currency with `Intl.NumberFormat`.

---

## 11) Interactive Survey (Conditional Fields)
**Goal:** Show extra input when selecting "Other".
**Events:** `change`

**Starter:**
```html
<label>Favorite fruit</label>
<select id="fruit">
  <option>Apple</option>
  <option>Banana</option>
  <option>Orange</option>
  <option>Other</option>
</select>
<input id="otherFruit" class="hidden" placeholder="Please specify" />
```
```js
fruit.addEventListener('change', () => {
  // TODO: toggle #otherFruit.hidden based on value === 'Other'
});
```
**Challenges:** Require the extra field only when visible.

---

## 12) Username Availability (Simulated)
**Goal:** On blur, fake a server check and show Available/Taken.
**Events:** `blur`

**Starter:**
```html
<input id="username" placeholder="Choose a username" />
<small id="userMsg"></small>
```
```js
username.addEventListener('blur', () => {
  // TODO: use setTimeout to simulate delay then randomize status
});
```
**Challenges:** Disable submit while checking.

---

## 13) Real-time Form Progress Bar
**Goal:** Increase progress as fields are completed.
**Events:** `input`, `change`

**Starter:**
```html
<input class="req" placeholder="Field 1" />
<input class="req" placeholder="Field 2" />
<input class="req" placeholder="Field 3" />
<progress id="progress" max="100" value="0"></progress>
```
```js
const req = Array.from(document.querySelectorAll('.req'));
const progress = document.getElementById('progress');
function updateProgress(){
  // TODO: count non-empty req inputs -> percentage
}
req.forEach(el => el.addEventListener('input', updateProgress));
```
**Challenges:** Deduct for invalid inputs.

---

## 14) Block Copy/Paste in Password
**Goal:** Disallow clipboard actions in password input.
**Events:** `copy`, `paste`, `cut`

**Starter:**
```html
<input id="pw" type="password" placeholder="Password" />
<small class="hint">Copy/Paste is disabled for this field.</small>
```
```js
['copy','paste','cut'].forEach(type => {
  pw.addEventListener(type, (e) => {
    // TODO: e.preventDefault()
  });
});
```
**Challenges:** Show a tooltip explaining why.

---

## 15) Custom Form Submission Summary
**Goal:** Prevent real submit; show a data summary below.
**Events:** `submit`

**Starter:**
```html
<input name="fullName" placeholder="Full name" />
<input name="email" placeholder="Email" />
<button type="submit">Review</button>
<div id="summary"></div>
```
```js
form.addEventListener('submit', (e) => {
  e.preventDefault();
  const fd = new FormData(form);
  // TODO: build a summary from fd entries and render into #summary
});
```
**Challenges:** Include checkboxes, radios, selects; pretty-print as a table.

---

## Extra Credit Ideas
- **Debounce** input validation to avoid excessive reflows.
- Use **event delegation** to handle many inputs from a single parent.
- Show **ARIA live regions** for validation messages (accessibility).
- Persist form state to **localStorage** and restore on load.

---

## Submission Checklist
- [ ] Each task works as described
- [ ] No console errors
- [ ] Clear comments explaining event handling
- [ ] Bonus: Accessibility considerations (labels, aria-live)

---

## Rubric (10 pts per task)
- **Correctness (5):** Implements required behavior & events
- **Code Quality (3):** Clean, readable, minimal global state
- **UX (2):** Helpful messages, no surprises


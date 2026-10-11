# 01 · Entry Rules

**Topic:** NOT, AND, OR and grouping

Ask for an age and three boolean values: whether the person has a ticket, is a VIP, and is blocked. Entry is allowed only when the person is not blocked and is either an adult with a ticket or a VIP. An adult is at least 18 years old. Inputs for the boolean questions are lowercase `true` or `false`.

## Requirements

- Store the rule in a `boolean allowed` variable using `!`, `&&`, `||`, and parentheses.

Values entered after prompts are typed by the user.

```console
Give age:
17
Has ticket:
false
Is VIP:
true
Is blocked:
false
Entry allowed.
```

```console
Give age:
30
Has ticket:
true
Is VIP:
false
Is blocked:
true
Entry denied.
```

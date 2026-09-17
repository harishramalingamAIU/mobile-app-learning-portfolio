# Module 2 — Building app UI

## Overview

Unit 2 contains three pathways with a stated duration of **21 hours**. It continues Kotlin fundamentals and introduces interactive applications.

The learning outcomes include:

- Use conditionals, function types, classes, and lambda expressions.
- Understand composition and recomposition.
- Add buttons and respond to user taps.
- Work with user-entered data.
- Use state so the UI reflects changes automatically.
- Write unit tests for isolated functions.

## Kotlin Techniques

Conditionals allow application behaviour to depend on data or user actions. Classes organise related data and behaviour, while lambda expressions allow functions to be passed as values.

These Kotlin features are particularly useful with Compose because many UI components receive functions as event handlers. A button, for example, can receive an `onClick` lambda that runs when the user taps it.

## Composition and Recomposition

Jetpack Compose uses a declarative UI model. Instead of manually updating individual views, the developer describes the UI based on its current state.

```text
State
  ↓
Composable function
  ↓
Displayed UI
  ↓
User interaction
  ↓
State changes
  ↓
Recomposition
  ↓
Updated UI
```

This differs from traditional imperative UI programming. The developer focuses on defining what the UI should look like for a particular state.

## State and Interaction

State allows the interface to respond automatically to changes. For example, if a counter starts at 0 and a user presses a button, the state can change to 1 and the UI displays the new value.

The important design issue is state ownership. Small temporary UI state can remain close to a composable, while shared or longer-lived state may need a higher-level owner such as a ViewModel.

## Testing

The introduction of unit testing demonstrates that functionality should be verified rather than assumed. Testing isolated functions can identify incorrect logic early and makes future changes safer.

## Strengths

- Introduces interactive UI development.
- Demonstrates declarative UI and state-driven behaviour.
- Connects Kotlin features directly to Android development.
- Introduces unit testing.

## Limitations and Challenges

Composition and recomposition require a different mental model from traditional UI development. Incorrect state management can cause unexpected behaviour or unnecessary recomposition. Developers also need to decide where state should be stored.

## Reflection

Unit 2 changed my understanding of UI development from simply creating screens to managing the relationship between user actions, data, state, and the displayed interface.

---
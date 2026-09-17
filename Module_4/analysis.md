# Module 4 — Navigation and app architecture

## Overview

Unit 4 contains three pathways with a stated duration of **28 hours**. It introduces application architecture, lifecycle, state management, navigation, and adaptive UI.

The learning outcomes include:

- Explain activities and their lifecycles.
- Understand modern Android architecture.
- Use StateFlow and the unidirectional data flow (UDF) pattern.
- Add a ViewModel to save data and state.
- Use the Navigation component with Compose.
- Understand adaptive and responsive design.
- Use window size classes for multiple form factors.
- Add a navigation drawer.

## Lifecycle and Architecture

Android applications operate within lifecycle-driven environments. A screen may be created, stopped, resumed, or recreated. Therefore, important state should not always be tied directly to a particular UI instance.

Modern architecture separates responsibilities so that the UI does not have to contain every piece of application logic.

```text
+-----------------------+
|       Compose UI      |
+-----------+-----------+
            |
          Events
            ↓
+-----------------------+
|      ViewModel        |
|     State + Logic     |
+-----------+-----------+
            |
        Data work
            ↓
+-----------------------+
|     Data layer        |
+-----------------------+
```

## StateFlow and UDF

StateFlow can expose observable state, while unidirectional data flow creates a predictable relationship between user events and state.

```text
User
 ↓
UI Event
 ↓
ViewModel
 ↓
State update
 ↓
StateFlow
 ↓
UI observes state
 ↓
UI recomposes
```

This reduces ambiguity about where state changes originate.

## ViewModel

ViewModel provides a lifecycle-aware location for UI-related state and logic. It helps prevent the UI layer from becoming responsible for every processing operation.

The main benefit is separation of concerns. The trade-off is that additional architecture can be unnecessary for very small applications, so state should be placed at an appropriate level rather than automatically moving everything into ViewModel.

## Navigation

The Navigation component provides a structured way to connect multiple destinations.

```text
Home
 ├── List
 │    └── Detail
 ├── Profile
 └── Settings
```

Navigation also involves back-stack behaviour and data passing. Therefore, it is an architectural concern rather than merely a visual screen transition.

## Adaptive and Responsive Design

Android applications can run on different screen sizes and form factors. A fixed layout designed only for one phone size may not use larger screens effectively.

Window size classes provide a way to make layout decisions according to available space.

```text
Compact window  → Compact layout

Larger window   → Expanded/adaptive layout
```

This approach allows the interface structure to adapt rather than simply stretching a fixed design.

## Navigation Drawer

A navigation drawer provides a way to move between major application destinations. It can be useful when an application has several sections, although the navigation pattern should be selected according to the application's structure and available space.

## Strengths

- Introduces scalable application architecture.
- Separates UI from state and logic.
- Provides structured navigation.
- Supports predictable state/event flow.
- Addresses different screen sizes and form factors.

## Limitations and Challenges

Architecture introduces more concepts and code. For small applications, excessive layering can make a simple solution unnecessarily complicated. StateFlow, UDF, lifecycle behaviour, and adaptive layouts also require additional understanding and testing.

## Reflection

Unit 4 demonstrated why larger applications need clear responsibility boundaries. I learned that UI, state, events, navigation, and data operations should have appropriate ownership. Adaptive design also showed that applications need to consider different devices and available screen space.

---
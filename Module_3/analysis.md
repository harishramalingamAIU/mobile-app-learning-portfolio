# Module 3 — Display lists and use Material Design

## Overview

Unit 3 contains three pathways with a stated duration of **15 hours**. It focuses on displaying collections of data and creating consistent interfaces using Material Design.

The learning outcomes include:

- Use data classes, functions, and collections in Kotlin.
- Create a scrollable list containing text and images.
- Add click listeners to list items.
- Add an app bar and modify the application theme.
- Use Material Design with colours, shapes, and typography.

## Data Classes and Collections

Data classes provide a structured way to represent application information. A collection can contain multiple objects and the UI can display those objects through a reusable component.

```text
Data class
    ↓
Collection
    ↓
Scrollable list
    ↓
Reusable list item
```

This separates the information being displayed from the way it is presented. Adding another item can therefore involve adding data rather than creating another completely separate UI implementation.

## Scrollable Lists

Scrollable lists are necessary when content exceeds the available screen space. Reusable list-item components allow the same UI structure to display different data.

This approach is more maintainable than creating a separate layout for every item.

## Click Listeners

Click listeners make list content interactive. Selecting an item can trigger an action such as displaying details or navigating to another destination.

A useful separation is:

- The list item displays information.
- The click event communicates the user's action.
- Application logic determines what happens next.

## Material Design

Material Design provides a design system containing components and principles for colour, typography, shapes, layout, and interaction.

Using a design system reduces repetitive styling decisions and encourages consistency between screens. Themes can also centralise visual decisions, making later changes easier.

However, using Material components alone does not guarantee a good interface. Readability, hierarchy, accessibility, spacing, and appropriate component selection still require developer judgement.

## Strengths

- Introduces data-driven UI.
- Demonstrates reusable list components.
- Adds interaction to collections of data.
- Introduces consistent UI through Material Design.
- Provides experience with themes and app bars.

## Limitations and Challenges

Lists introduce additional considerations such as item identity, scrolling, performance, and changes to the underlying data. Material Design also needs to be applied thoughtfully rather than simply adding visual styling.

## Reflection

The key lesson from Unit 3 was the relationship between structured data and reusable UI. I learned that applications become easier to extend when data and presentation are separated. Material Design also showed that technical implementation and user experience are closely connected.

---
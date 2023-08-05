# JavaDesignPatterns

This repository is a personal space to practice writing some Test Driven Development Java while also revisiting the Gang of Four design patterns. The ultimate goal is to have at least one example of each of the 23 design patterns.

## Who are the Gang of Four?

Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides. Collectively they are known as the "Gang of Four" and the four authors of the book, _Design Patterns: Elements of Reusable Object-Oriented Software_. This is likely one of the most important software engineering books published in modern software engineering.

## What are the 23 design patterns?

The patterns are broken into three major categories: Creation, Structural, and Behavioral. Each of these categories has 2 sub-categories: Class patterns and Object patterns. At a high level, Class patterns deal with inheritance (classes and their subclasses), which has fixed types at compile time. Object patterns deal with relationships between objects, whose types may change at runtime. 

Each major- and sub-category is explained below.

### Creation Patterns
The Creation pattern archetypes describe the process of object creation. Creational Class patterns defer parts of object creation to subclasses. Creational Object patterns defer object creation to other objects.

1. (Class) Factory Method
  1. Implemented in: `abstractFactory`
1. (Object) Abstract Factory
  1. Implemented in: `abstractFactory`
1. (Object) Builder
1. (Object) Prototype
1. (Object) Singleton
  1. Implemented in: `abstractFactory`

### Structural Patterns
The Structural pattern archetypes deal with how objects are composed. Structural Class patterns use inheritance to compose classes. Structural Object patterns describe way to assemble objects together.

1. (Class _and_ Object) Adapter
1. (Object) Bridge
1. (Object) Composite
1. (Object) Decorator (aka Wrapper)
1. (Object) Facade
1. (Object) Flyweight
1. (Object) Proxy

### Behavior Patterns

The Behavior pattern archetypes describe how objects may interact with one another. Behavior Class patterns use inheritance to describe algorithms and flow control. Behavior object patterns describe how many objects work together to accomplish a task.

1. (Class) Interpreter
1. (Class) Template
1. (Object) Chain of Responsibility
1. (Object) Command
1. (Object) Iterator
1. (Object) Mediator
1. (Object) Observer
1. (Object) State
1. (Object) Strategy
1. (Object) Visitor

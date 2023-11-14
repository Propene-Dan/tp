---
layout: page
title: Bingxi's Project Portfolio Page
---

### Project: TASsistant

TASsistant is a desktop address book application used for teaching Software Engineering principles.
The user interacts with it using a CLI, and it has a GUI created with JavaFX.
It is written in Java, and has about 10 kLoC.

Given below are my contributions to the project.

* **New Feature**: Added the ability to add/remove a person to a tutorial.
  * Pull requests: [\#77](https://github.com/AY2324S1-CS2103T-F12-3/tp/pull/77), and [\#107](https://github.com/AY2324S1-CS2103T-F12-3/tp/pull/107/).

* **New Feature**: Added a tutorialTime field to tutorial model.

* **New Feature**: Added an auto-formatting feature for the tutorialTime.
  * What it does: Auto-format the tutorialTime of a tutorial.
  * Justification: This feature allows the user not worrying too much about the format of the tutorial time.
  * Pull requests: last for commits of [\#107](https://github.com/AY2324S1-CS2103T-F12-3/tp/pull/107/), and [\#219](https://github.com/AY2324S1-CS2103T-F12-3/tp/pull/219).

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2324s1.github.io/tp-dashboard/?breakdown=true&search=propene-dan&sort=groupTitle%20dsc&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByAuthors&since=2023-09-22&checkedFileTypes=docs~functional-code~test-code~other&tabOpen=false)

* **Enhancements to existing features**:
    * Fixed test cases that broke after refactoring tutorial time.

* **Documentation**:
    * User Guide:
        * Added documentation for `addToTutorial`, `removeFromTutorial` and statements about tutorialTime in `addTutorial`.

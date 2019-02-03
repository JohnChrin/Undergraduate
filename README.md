# Undergraduate
# ![McccLogo](https://github.com/Spades86/Undergraduate/blob/master/images/McccLogo.png) ![DrexelLogo](https://github.com/Spades86/Undergraduate/blob/master/images/DrexelLogo.png) ![WcuLogo](https://github.com/Spades86/Undergraduate/blob/master/images/WcuLogo1.png)
## Introduction
This repository is a collection of all undergraduate programming work in 5 languages. While a majority of the projects are Java related. I also have experience with functional programming languages.
* [Java](https://github.com/Spades86/Undergraduate/tree/master/Java) 1991
* [Python](https://github.com/Spades86/Undergraduate/tree/master/Python) 1995
* [C/C++](https://github.com/Spades86/Undergraduate/tree/master/C)
* [Lisp](https://github.com/Spades86/Undergraduate/tree/master/LISP)
* [SML](https://github.com/Spades86/Undergraduate/tree/master/SML)

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
This project is simple Lorem ipsum dolor generator.

## Technologies
Project is created with:
* Lorem version: 12.3
* Ipsum version: 2.33
* Ament library version: 999
	
## Setup
To run this repository of projects in its entirety, you must have an [IDE](https://en.wikipedia.org/wiki/Integrated_development_environment)/s capable of supporting the execution of [Java](https://www.oracle.com/technetwork/java/javase/overview/index.html), [Python](https://www.python.org/), [C/C++](http://www.mingw.org/), [CMUCL](https://www.cons.org/cmucl/), & [SMLNJ](https://www.smlnj.org/).

May I recommend [Eclipse](https://www.eclipse.org/) (Eclipse IDE for Java Developers, selected at installation) as your IDE of choice,  which if configured correctly will enable the execution of everything contained in this repository.

Recommended Plugins:
* [EGit](https://marketplace.eclipse.org/content/egit-git-integration-eclipse) - Allows the linking of [Git Hub](https://github.com/) and Eclipse directly inside of the IDE. This will require the generation and linking of some SSH keys ([Eclipse&GitKeySetup.pdf](http://wiki.cns.iu.edu/spaces/flyingpdf/pdfpageexport.action?pageId=13568315)).

Required Plugins:
* [PyDev](https://marketplace.eclipse.org/content/pydev-python-ide-eclipse) - This enables the execution of Python code.
* [C/C++ IDE](https://marketplace.eclipse.org/content/complete-eclipse-cc-ide) - This enables the exectuion of C/C++ code.
* [Dandelion](https://marketplace.eclipse.org/content/dandelion) - This enables the execution of CMUCL (Lisp) code. In order to implement this plugin with Eclipse in conjunction with Egit
* [MLDev](https://github.com/andriusvelykis/ml-dev) - This enables the execution of SML code. In order to implement this plugin, you must use the Help>[Install New Software](https://stackoverflow.com/questions/31553376/eclipse-how-to-install-a-plugin-manually) button inside of Eclipse and post this link: http://andriusvelykis.github.io/ml-dev/updates/nightly/ 


```
$ cd ../lorem
$ npm install
$ npm start
```

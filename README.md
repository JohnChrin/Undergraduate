# Undergraduate -> Bachelors Computer Science (2018)
# ![McccLogo](https://github.com/Spades86/Undergraduate/blob/master/images/McccLogo.png) ![DrexelLogo](https://github.com/Spades86/Undergraduate/blob/master/images/DrexelLogo.png) ![WcuLogo](https://github.com/Spades86/Undergraduate/blob/master/images/WcuLogo.png?raw=true)
## Introduction
This repository is a collection of all undergraduate programming work in five languages. While a majority of the projects are Java related, I also have experience with functional programming languages. Some of the code is refactored due increased coding competency, but the primary function of this repository is for experimentation with organization, documentation, and presentation.\
\
Formatting the presentation of five languages into a single respository (repo) brings attention to a deeper concept of programming, that being the paradigms between different types of languages. Programming paradigms are essentially a programming language's approach to problem solving. There are four programming paradigms and if a problem can be solved in one, it is also able to be solved in any of the other three. This may be confusing to some so try and think about programming paradigms as if there are only four brains (four types of programming languages) in the world and they all approach solving problems differently and if any one of those brains figures it out, the other three are able to as well. Each sub-repo contained in this collection is labeled with the type of paradigm it solves problems with. 

<b>Education</b>: \
Bachelors of Computer Science, West Chester University, West Chester, PA, 3.5 GPA \
Associates of Mathematics, Montgomery County Community College, Blue Bell, PA, 3.9 GPA


## Contents of Repository (Quick Links to Language Specific Sections)
* [Java](https://github.com/Spades86/Undergraduate/tree/master/Java) &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Sub-repo of Java projects.
* [Python](https://github.com/Spades86/Undergraduate/tree/master/Python) - Sub-repo of Python projects.
* [C/C++](https://github.com/Spades86/Undergraduate/tree/master/C) - Sub-repo of C/C++ projects.
* [LISP](https://github.com/Spades86/Undergraduate/tree/master/LISP) &nbsp;&nbsp;&nbsp;&nbsp;- Sub-repo of CMUCL projects.
* [SML](https://github.com/Spades86/Undergraduate/tree/master/SML)  &nbsp;&nbsp;&nbsp;&nbsp;- Sub-repo of SML projects.

	
## Setup
To run this repository of projects in its entirety, you must have an [IDE](https://en.wikipedia.org/wiki/Integrated_development_environment)/s capable of supporting the execution of [Java](https://www.oracle.com/technetwork/java/javase/overview/index.html), [Python](https://www.python.org/), [C/C++](http://www.mingw.org/), [CMUCL](https://www.cons.org/cmucl/), & [SMLNJ](https://www.smlnj.org/).

May I recommend [Eclipse](https://www.eclipse.org/) (Eclipse IDE for Java Developers, selected at installation) as your IDE of choice,  which if configured correctly will enable the execution of everything contained in this repository.

<b>Recommended Plugins</b>:
* [EGit](https://marketplace.eclipse.org/content/egit-git-integration-eclipse) - Allows the linking of [GitHub](https://github.com/) and Eclipse directly inside of the IDE. This will require the generation and linking of some SSH keys ([Eclipse&GitKeySetup.pdf](http://wiki.cns.iu.edu/spaces/flyingpdf/pdfpageexport.action?pageId=13568315)).

<b>Required Plugins</b>:
* [PyDev](https://marketplace.eclipse.org/content/pydev-python-ide-eclipse) - This enables the execution of Python code.
* [C/C++ IDE](https://marketplace.eclipse.org/content/complete-eclipse-cc-ide) - This enables the exectuion of C/C++ code.
* [Dandelion](https://marketplace.eclipse.org/content/dandelion) - This enables the execution of CMUCL (LISP) code. In order to implement this plugin with Eclipse in conjunction with EGit you must follow these [directions](https://github.com/Spades86/Undergraduate/blob/master/images/LispProjectConfigDirections.txt) written by [bwal213](https://github.com/bwal213) (big credit to @bwal213 for his contribution to this deprecated plugin, hopefully we will coordinate an auto-executed script or even better, update the plugin).
* [MLDev](https://github.com/andriusvelykis/ml-dev) - This enables the execution of SML code. In order to implement this plugin, you must use the Help>[Install New Software](https://stackoverflow.com/questions/31553376/eclipse-how-to-install-a-plugin-manually) button inside of Eclipse and post this link: http://andriusvelykis.github.io/ml-dev/updates/nightly/ 

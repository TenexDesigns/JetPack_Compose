NAVIGATION COMPONENT

The navigation component is a suite of libralies ,tooling and guidance for in-app navigation.
The component centralizes all the navigation information of your app in a NAVIGATION GRAPH providing a robust framework for implementing everything from
simple button clicks to complex navigation ui patterns.


THE NAVIGATION COMPONENT CONSISTS OF THREE KEY PARTS

NAVIGATION GRAPH
A navigation graph is a new XML RESOURSE type that defines all possible paths a user can take through an app.
It shows visually all the destinations that can be reached from a given destination.

e.g
THIS SHOWS PATHS A USER CAN TAKE FROM ONE SCREEN TO ANOTHER.

         _______
         |     |    
         |     |    
         |  D  |------|
         |     |      |
         |     |      |
                      |
               --------
               |
               v
______      ____       _____
|    |     |    |     |    |
|    |     |    |     |    |
| A  |---> | B  | --->|  C |
|    |     |    |     |    |
|    |     |    |     |    |
  |
  |
  |
  |
  |      _______
  |--->  |     |    
         |     |    
         |  E  |   
         |     |    
         |     |  


NAVHOST
An empty container that displays destinations from your navigation grapgh.
Tje navigation component contains a default navhost implementation,NAVHOSTFRAGMENT, that displays fragment destinations
























































































































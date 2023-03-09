The Navigation Architecture Component simplifies navigation implementation while also assisting you in visualizing
your app’s navigation flow.
The library offers a variety of advantages, including:


1. Handling fragment transactions.
2. Handling Up and Back actions correctly by default.
3. Providing standardized resources for animations and transitions.
4. Implementing and handling deep linking.
5. Including Navigation UI patterns, such as navigation drawers and bottom navigation, with minimal additional work.
6. Safe Args - a Gradle plugin that provides type safety when navigating and passing data between destinations.
7. ViewModel support - you can scope a ViewModel to a navigation graph to share UI-related data between the graphs destinations.
8. Handling of fragment transactions automatically
9. By default, up and back actions are handled correctly.
10. Default animation and transition behaviors
11. Deep linking is regarded as a first-rate operation.
12. Implementing navigation UI patterns (such as navigation drawers and bottom navigation) with minimal additional effort
13. When navigating Android Studio tooling for visualizing and editing an app’s navigation flow, use type safety when passing information.


THE NAVIGATION COMPONENT IS MADE UP OF THEREE MAJOR PARTS

Navigation graph (New XML resource) 

This is a resource that collects all navigation-related data in one place.
This includes all of the locations in your app,referred to as destinations, as well as the possible paths a user could 
take through your app.

NavHost (Layout XML view)
This is a unique widget that you can include in your layout. 
It shows various destinations from your Navigation Graph.
The Navigation component contains a default NavHost implementation, NavHostFragment, that displays fragment destinations.

NavController(Kotlin/Java object)
An object that manages app navigation within a NavHost. The NavController orchestrates the swapping of destination content 
in the NavHost as users move throughout your app
This is an object that keeps track of where you are in the navigation graph.
As you move through a navigation graph, it orchestrates the swapping of destination content in the NavHostFragment.














































































































The Navigation Architecture Component simplifies navigation implementation while also assisting you in visualizing
your app’s navigation flow.
The library offers a variety of advantages, including:

1. Handling of fragment transactions automatically
2. By default, up and back actions are handled correctly.
3. Default animation and transition behaviors
4. Deep linking is regarded as a first-rate operation.
5. Implementing navigation UI patterns (such as navigation drawers and bottom navigation) with minimal additional effort
6. When navigating Android Studio tooling for visualizing and editing an app’s navigation flow, use type safety when passing information.


THE NAVIGATION COMPONENT IS MADE UP OF THEREE MAJOR PARTS

NAVIGATION GRAPH (New XML resource) 

This is a resource that collects all navigation-related data in one place.
This includes all of the locations in your app,referred to as destinations, as well as the possible paths a user could 
take through your app.

NAVHOSTFRAGMENT(Layout XML view)
This is a unique widget that you can include in your layout. 
It shows various destinations from your Navigation Graph.

NAVCONTROLLER(Kotlin/Java object)

This is an object that keeps track of where you are in the navigation graph.
As you move through a navigation graph, it orchestrates the swapping of destination content in the NavHostFragment.














































































































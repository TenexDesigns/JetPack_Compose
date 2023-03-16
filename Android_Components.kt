Android Architecture Components


TOPICS TO BE COVERED

What is android architecture
Overview of android jetpack
How architecture components are releted.



















ANDROID JETPACK
Android jetpack is a collection of android software components.
It makes android app development easy due to
- Minimalboiler plate code
- Helps us follow best plactices

The android jetpack is made up of 

1.Architecure
2.Foundation
3.Behaviour
4.UI



1.ARCHITECTURE
Data Bindinf
Lifecycle awar componets 
Live data
Navigation
Paging
Room
View model
Work manager


2.UI
Animation & Transations
Auto ,TV wear,
Emoji
Fragment
Layout
Pallete

3.BEHAVIOUR
Download manager
Mdeia & playback
Permissions
Notifications
Sharing
Slices


4.FOUNDATION
App compact
Android KTX
Multidex
Test




FOUNDATION

Life cycle Awaere components


- What are life cycle aware components
-How does it work
-What are lifecycleOwnwer & Lifecycle observer


THOS SECTION CPVERS
Whey do we neeed view model
Using view model
How liveData works
Using live data

VIEW MODEL
Provides data to ui, so that the data is not lost during configuration changes such change of orientation

Summary of view model
Survives configuration changes e.g screen rotation
Not same as onSaveInstanceState()
Used for large data such as ,bitmap or userlist
Stores and manage UI related data
Destroyed only if the owner Activity is completely desctryed in on onCleared()
Communication layer between DB and UI








































































































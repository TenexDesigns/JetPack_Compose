MVVM MODEL - Multiview View ViewModel

MODEL- Simply refers to the data access layer ,or database or the content

View - View Is the layout ,structure and appearance of what the user sees on the screen

View model class - Is designed to store and manane UI related data in a life concies way. the view model class allows data to survive configuration changes .eg screen rotation


WHY SHOULD WE USE MVVVM

1.Easy too write maintanable code - since you are separating the logic from the UI and the data from the UI
2.Easy to write testable code - By separating the data layer from the UI layer, you are able to test your data and UI separately.
3.Build a stable and robust app
4.Allow more than one person to work on the same CodeBase


THE MODEL - VIEW - VIEWMODEL FLOW 



UI -           |         Requests data from the view model                                        ^  The Ui receives the data in form of a UI sate from the view model and displays it to the user.
               |                                                                                  |
ViewModel -    |         Requests data fromm the  repository                                      |The view model receives the emited data and makes it into a UI state that the Ui can use .The view model then emits this data as uiState to the UI
               |                                                                                  |
Repository -   v         Requet Data from the Network or from the Local dataBase                  | The network or local databses sends required data back to the  repository. The repository then emits this data to the view model



The Network or Local Dataabse id the - Model part of the MVVM
The Vir=ewMode and the UI make up the - viewModel and the View part of the MVVM.
















































































































































## Muzz Example

This sample application is meant for giving an example of my abilities on the Android OS based on some requirements.

## Technical decisions

This has been built using a kind of Clean Architecture (which could be improved by adding "use-cases"), Room Database, ViewModel, Hilt for dependency Injection, Jetpack compose, StateFlow to be observed, for this I pbviously used the MVVM pattern, as this needs to have some observables

## How it works

- It opens on a WelcomeScreen which has just a TopAppBar and 2 buttons at its centre: one goes to "User" chats, the other one goes to "Sarah" chats
- At the very start, if not yet, the User entity gets populated automatically with 2 stub users
- When going to chats, it all gets populated as follows, additionally to a named TopAppBar with back chevron:
  - If there are no messages, only current hour will appear at the centre
  - If there are some messages, the ones by the other user are in grey; the ones from you are purple. There is also a "double check" to check if the message has been read. The last message older than 1 hour has the Time label on it.
 
## Possible improvements
- I would have added a backend to trace all the messages and the users, additionally to Room which caches all messages for offline purposes
- I just record 2 fake users, with more time I would have added some login logic so that at least a custom username could have been added
- For making it easy, I just added a RoomDatabase but without migration policies
- I wish I would have added more tests, but I added some basic Room tests anyway
- I also would have added localization

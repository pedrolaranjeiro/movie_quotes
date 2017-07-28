package com.flat14.movie_quotes.db

import android.content.Context

import com.flat14.movie_quotes.exceptions.NoMoreQuotesException

import java.util.ArrayList
import java.util.Random

class Database {

    private var quotes: MutableList<Quote> = ArrayList()
    private var wrongAnswers: MutableList<String> = ArrayList()

    private var lastWrongAnswerIndex = -1

    init {
        initQuotes()
        initWrongAnswers()
    }

    private fun initWrongAnswers() {
        wrongAnswers = ArrayList<String>()
        wrongAnswers.add("Wrong you stupid ass.")
        wrongAnswers.add("Hey donkey, try again.")
        wrongAnswers.add("Jesus, even my 2 year old know this one.")
        wrongAnswers.add("You are not worthy of this app. Please uninstall.")
        wrongAnswers.add("Cmon, use Google. I'll pretend you actually knew the answer.")
        wrongAnswers.add("Wrong!")
        wrongAnswers.add("Wrong!!!!!!!!!!!!")
        wrongAnswers.add("Why do you even try?")
        wrongAnswers.add("It's is so simple.")
        wrongAnswers.add("Have you notice a square box in your living room? Try to use it for once.")
        wrongAnswers.add("Stop watching reality TV.")
        wrongAnswers.add("Your favorite show must be the Teletubbies because you know nothing about films.")
        wrongAnswers.add("Please, stop playing. You suck!")
        wrongAnswers.add("You know nothing Jon Snow.")
        wrongAnswers.add("Are you failing on purpose just to see the wrong answers? This is a game. Try to play it.")
    }

    private fun initQuotes() {
        quotes = ArrayList<Quote>()
        quotes.add(Quote("This is your last chance. After this, there is no turning back. You take the blue pill, the story ends, you wake up in your bed and believe whatever you want to believe. You take the red pill, you stay in Wonderland and I show you how deep the rabbit-hole goes.", "Morpheus", "The Matrix"))
        quotes.add(Quote("Hasta la vista BABY!.", "T-100", "Terminator"))
        quotes.add(Quote("RRWWWGG", "Chewbacca", "Star wars"))
        quotes.add(Quote("I don't know who you are. I don't know what you want. If you are looking for ransom, I can tell you I don't have money. But what I do have are a very particular set of skills, skills I have acquired over a very long career. Skills that make me a nightmare for people like you. If you let my daughter go now, that'll be the end of it. I will not look for you, I will not pursue you. But if you don't, I will look for you, I will find you, and I will kill you.", "Bryan", "Taken"))
        quotes.add(Quote("You talkin' to me? Then who the hell else are you talking... you talking to me? Well I'm the only one here. Who the fuck do you think you're talking to?", "Travis Bickle", "Taxi Driver"))
        quotes.add(Quote("I am Groot", "Groot", "Guardians of The Galaxy"))
        quotes.add(Quote("They may take our lives, but they will never take... our FREEDOM!", "William Wallace", "Braveheart"))
        quotes.add(Quote("I see dead people.", "Cole Sear", "The Sixth Sense"))
        quotes.add(Quote("Mama always said life was like a box of chocolates. You never know what you're gonna get.", "Forest", "Forest Gump"))
        quotes.add(Quote("Say 'what' again. Say 'what' again, I dare you, I double dare you motherfucker, say what one more Goddamn time!", "Jules", "Pulp Fiction"))
        quotes.add(Quote("My Precious", "Gollum", "Lord of the Rings"))
        quotes.add(Quote("Why so serious?", "Joker", "The Dark Knight"))
        quotes.add(Quote("Do or do not. There is no try", "Yoda", "Star wars"))
        quotes.add(Quote("I'm the king of the world!", "Jack Dawson", "Titanic"))
        quotes.add(Quote("I'll be back", "T-100", "Terminator"))
        quotes.add(Quote("You're going to need a bigger boat", "Chief Brody", "jaws"))
        quotes.add(Quote("Wax on, wax off.", "Daniel", "The Karate Kid"))
        quotes.add(Quote("Houston, we have a problem", "Jim Lovell", "Apollo 13"))
        quotes.add(Quote("May the Force be with you.", "Han Solo", "Star Wars"))
        quotes.add(Quote("I live my life a quarter mile at a time", "Dom", "The Fast and the Furious"))
        quotes.add(Quote("There's no place like home", "Dorothy", "The Wizard of Oz"))
        quotes.add(Quote("SHOW ME THE MONEYYYYY!", "Jerry", "Jerry Maguire"))
        quotes.add(Quote("Beneath this mask there's more than flesh. Beneath this mask there is an idea Mr. Creedy. And ideas are bullet proof", "V", "V for Vendetta"))
        quotes.add(Quote("What doesn't kill you, makes you .... stranger..", "Joker", "The Dark knight"))
        quotes.add(Quote("Good morning, Vietnam! Hey, this is not a test. This is rock and roll.", "Adrian Cronauer", "Good morning Vietnam"))
        quotes.add(Quote("I'll have what she's having.", "Client", "When Harry Met Sally"))
        quotes.add(Quote("Here's Johnny!", "Jack Torrance", "The Shining"))
        quotes.add(Quote("I'm going to make him an offer he can't refuse.", "Vito Corleone", "The Godfather"))
        quotes.add(Quote("Do I feel lucky? Well, do ya, punk?", "Harry Callaghan", "Dirty Harry"))
        quotes.add(Quote("I love the smell of napalm in the morning.", "Lt. Col. Bill Kilgore", "Apocalypse Now"))
        quotes.add(Quote("Go ahead, make my day.", "Harry Callaghan", "Sudden Impact"))
        quotes.add(Quote("You can't handle the truth!", "Col. Nathan R. Jessup", "A few good men"))
        quotes.add(Quote("The greatest trick the Devil ever pulled, was convincing the world he didn't exist", "Verbal Kint", "The usual suspects"))
        quotes.add(Quote("Say 'hello' to my little friend!", "Tony Montana", "Scarface"))
        quotes.add(Quote("A census taker once tried to test me. I ate his liver with some fava beans and a nice Chianti.", "Dr Hannibal", "The Silence of the lambs"))
        quotes.add(Quote("Get busy living, or get busy dying.", "Andy Dufresne", "The Shawshank Redemption"))
        quotes.add(Quote("Gentlemen, you can't fight in here! This is the War Room!", "President Merkin Muffley", "Dr. Strangelove or: How I Learned to Stop Worrying and Love the Bomb"))
        quotes.add(Quote("Ever since I can remember I always wanted to be a gangster. To me that was better than being president of the United States. To be a gangster was to own the world.", "Henry Hill", "Goodfellas"))
        quotes.add(Quote("Carpe diem. Seize the day, boys. Make your lives extraordinary.", "John Keating", "Dead Poets Society"))
        quotes.add(Quote("Bond. James Bond", "James Bond", "Dr. No"))
        quotes.add(Quote("All those moments will be lost in time… like tears in rain.", "Roy Batty", "Blade Runner"))
        quotes.add(Quote("I've got a feeling we're not in Kansas anymore", "Dorothy", "The wizard of oz"))
        quotes.add(Quote("Wax on, wax off.", "Daniel", "The Karate Kid"))
        quotes.add(Quote("Nobody puts Baby in a corner.", "Johnny", "Dirty Dancing"))
        quotes.add(Quote("What we've got here is failure to communicate", "Captain, Road Prison 36", "Cool Hand Luke"))
        quotes.add(Quote("“They may take our lives, but they will never take... our FREEDOM!", "William Wallace", "Braveheart"))
        quotes.add(Quote("Ideals are peaceful. History is violent.", "Don Collier", "Fury"))
        quotes.add(Quote("You mustn't be afraid to dream a little bigger, darling", "Eames", "Inception"))
        quotes.add(Quote("Shit! You shoot me in a dream, you better wake up and apologize", "Mr White", "Reservoir Dogs"))
        quotes.add(Quote("You're gonna eat lightnin' and you're gonna crap thunder!", "Mickey", "Rocky"))
        quotes.add(Quote("Power is when we have every justification to kill, and we don't.", "Oskar Schindler", "Schindler's List"))
        quotes.add(Quote("You know you really don't need a damn forensics team to get to the bottom of this. If you guys were the inventors of Facebook you'd have invented Facebook.", "Mark Zuckerberg", "The social network"))
        quotes.add(Quote("Live long and prosper", "Spock", "Star Trek"))
        quotes.add(Quote("You are all singing, all dancing crap of the world.", "Tyler Durden", "Fight Club"))
    }

    @Throws(NoMoreQuotesException::class)
    fun getNextQuote(context: Context): Quote {
        val quoteIndex = Prefs.getQuoteIndex(context)
        if (quoteIndex >= quotes.size) {
            throw NoMoreQuotesException("There are no more quotes")
        }

        val quote = quotes[quoteIndex]
        Prefs.saveCurrentIndex(context, quoteIndex)
        return quote
    }

    fun getCorrectAnswer():String{
        return "Congrats, well done"
    }

    fun getWrongAnswer():String{
        var wrongIndex = -1
        do {
            wrongIndex = Random().nextInt(wrongAnswers.size - 1)
        } while (wrongIndex == -1 || wrongIndex == lastWrongAnswerIndex)
        lastWrongAnswerIndex = wrongIndex
        return wrongAnswers[lastWrongAnswerIndex]
    }

}
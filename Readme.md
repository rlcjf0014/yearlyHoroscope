# Overview

The Yearly Horoscope Program provides information on zodiac sign and horoscope for the given genre. It allows the user to input birth date to find out what the user's yearly horoscope has to say on their career or love life. WIth this program, you can:

* Get your zodiac sign
* Find out what your yearly horoscope is. 
* Find out how many times you used this program to get your horoscope. 

# Usage

To use the Yearly Horoscope Program, run the following after downloading the code:

```
$ javac *.java
$ java YearlyHoroscope HoroscopeTextFile.txt
```
where `HoroscopeTextFile.txt` is which horoscope text file you would like your program to read from. The options are `CareerHoroscope.txt` and `LoveHoroscope.txt` and will determine whether the program gives you a horoscope on career or love life.

The program will then ask you what you’d like to do:

```js
$ javac *.java
$ java YearlyHoroscope CareerHoroscope.txt
$ Welcome to Yearly Horoscope! 

$Please enter your birth month in number. (MM)
$11

$Please enter your birth day in number.
$8

$Your zodiac sign is Scorpio! 

$Your CareerHoroscope is 

$Scorpio: Your determined sign is always on top of the current market trends occurring in your field of business. You are excellent at self-promotion ready and willing to invest your time into what really counts for your future. You have no problem holding out for a better deal or making sacrifices to get where you need to go.

$ Do you want to try again with a different birth date for someone else?

$ Type Yes or Exit
$ Exit

$ Thank you for using Yearly Horoscope. You received yearly horoscope 1 time(s)
```

# Rubric
My project meets each of the rubric requirements and respond to the HW1 prompt. 

### Compiles without warnings and runs

When my code compiles, it is able to run successfully with both text files without producing any warnings or errors. This can be seen by running the following:

```
$ javac *.java
$ java YearlyHoroscope LoveHoroscope.txt
```
and
```
$ javac *.java
$ java YearlyHoroscope CareerHoroscope.txt
```

### New Class Created Correctly




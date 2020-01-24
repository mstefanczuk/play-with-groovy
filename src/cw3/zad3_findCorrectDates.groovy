package cw3

import java.time.DateTimeException
import java.time.LocalDate

// Daty w tekście maja postać YYYY-MM-DD (rok- miesiac- dzien). Wypisać wszystkie poprawne daty.
// czyli: po wyróznieniu wszytskicgh fragmentów, które mogą być datami sprawdizc ich poprawnośc
// (np. czy właściwa jest liczba dni w miesiącu)

File file = new File('./zad3_findCorrectDates_input.txt')

def stringBuffer = new StringBuffer()
file.withReader { reader ->
    while ((line = reader.readLine()) != null) {
        stringBuffer << line
    }
}

correctDates = []

stringBuffer.toString()
        .findAll('\\d{4}-\\d{2}-\\d{2}')
        .each { date ->
            tmp = date.split("-").collect { it -> Integer.valueOf(it) }
            try {
                correctDates.add(LocalDate.of(tmp[0], tmp[1], tmp[2]))
            } catch (DateTimeException ignored) {
            }
        }

println correctDates

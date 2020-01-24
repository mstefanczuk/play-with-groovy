package cw4

import groovy.json.JsonSlurper

//Plik MenuPl.txt zawiera menu w postaci:
//nazwa_dania cena
//
//Ceny sa w PLN.
//Na podstawie pliku wejsciowego stworzyc plik MenuEur.txt majacy te sama postac, ale z cenami w EUR.

def menuPlFile = new File("MenuPl.txt")
def menuEurFile = new File("MenuEur.txt")
menuEurFile.text = ""

def rate = new JsonSlurper()
        .parse(new URL('https://api.exchangeratesapi.io/latest?base=PLN&symbols=EUR'))["rates"]['EUR']

menuPlFile.each {
    def splittedRow = it.split(" ")
    def calculatedPrice = String.format("%.2f", (splittedRow[1] as BigDecimal) * rate)
    menuEurFile.text += splittedRow[0] + " " + calculatedPrice + "\n"
}

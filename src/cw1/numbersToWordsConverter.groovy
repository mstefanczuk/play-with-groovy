package cw1

// Napisać program przekształcający liczby na ich słowne odpowiedniki.
// Np. po wprowadzeniu liczby 147 winniśmy uzyskać jeden - cztery - siedem.

def map = [
        0: "zero",
        1: "jeden",
        2: "dwa",
        3: "trzy",
        4: "cztery",
        5: "piec",
        6: "szesc",
        7: "siedem",
        8: "osiem",
        9: "dziewiec",
]

println 'Podaj liczbę:'
def number = System.in.newReader().readLine() as Integer

def numbers = "$number".toList().collect { it as Integer }

def lastNumber = numbers.last()

numbers.each {
    print map.get(it)
    if (it != lastNumber) {
        print ' - '
    }
}

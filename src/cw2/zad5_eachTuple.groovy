package cw2

// Zapewnić iterowanie na Iterable za pomocą metody eachTuple, umożliwiającej działanie podanego domknięcia
// na kolejnych  n-kach elemntow. Liczba n wynikać ma z liczby argumentów domknięcia.

def list = (1..40)

eachTuple(list) { e1, e2, e3, e4 ->
    println "$e1 $e2 $e3 $e4"
}

def s = 'asia ma kota i psa'

def out = new StringBuffer()
eachTuple(s) { a,b ->
    out << b << a
}
println out

def eachTuple(input, Closure closure) {
    def n = closure.maximumNumberOfParameters
    def tuple = []
    input.each {
        tuple.add it
        if (tuple.size() == n) {
            closure(tuple)
            tuple.clear()
        }
    }
}

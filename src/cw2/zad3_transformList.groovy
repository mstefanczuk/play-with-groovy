package cw2

// Napisać funkcję List apply(List l, Closure c),
// która każdy element listy l transformuje za pomocą domknięcie c i zwraca listę transformowanych wartości.

def list1 = 1..5
def list2 = ['a', 'b', 'c']

def closure1 = { i -> i + i }
def closure2 = { i ->
    if (i == 'a') {
        return 'tu bylo "a"'
    } else {
        return 'tu nie bylo "a"'
    }
}

println apply(list1, closure1)
println apply(list2, closure1)
println apply(list1, closure2)
println apply(list2, closure2)

static def apply(List l, Closure c) {
    return l.collect(c)
}

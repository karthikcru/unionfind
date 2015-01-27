var a = Map [Int,Int] ()
a= a +(5->5) + (6->66) + (7->77) + (8->66)
a
var b = (99->99)
a.par.filterKeys(key=> a(key)==66).par.map( a => (a._1,5))
a+b

(0 to 10 ).toList
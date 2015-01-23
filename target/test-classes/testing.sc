
import scala.collection.immutable.{HashSet, HashMap}
var a = new HashMap[Int,Int]
a= a + (5->5) + (6->65)
a= a - 5
a
object summer{
def addELe(a:List[Int],map:HashMap[Int,Int]): HashMap[Int,Int] =
a match{

  case x::Nil => map.+(x->x)
  case x::xs => addELe(xs,map.+(x->x))


}}
//
//def addda(a:HashMap[Int,Int],c:HashMap[Int,Int]):HashMap[Int,Int]= {
//  a++c
//}

//List(HashMap(5->5),HashMap(6->6)).fold(a.empty)(addda)




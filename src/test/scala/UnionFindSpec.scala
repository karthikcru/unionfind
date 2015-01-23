package unionfind
import org.scalatest.{FlatSpec, Matchers}


import scala.collection.immutable.{HashSet, HashMap}

/**
 * Created by indix on 23/1/15.
 */
class UnionFindSpec extends FlatSpec with Matchers {
  val elements = List(1,2,3,4,5)
  val unionFind = new UnionFind(elements)
  "UnionFind" should "insert all elements passed to it into individual cluster" in {
    
    unionFind.el.size should be (5)
    unionFind.el.toList.map(_._1).toSet should be (elements.toSet)
  }
  
  it should "perform the union of clusters" in {
    unionFind.union(2, 3)
    unionFind.find(2, 3) should be(true)
    val c = unionFind.el.get(1).get
    unionFind.el should be(HashMap(
      1 -> new unionFind.cluster(1, HashSet(1)),
      2 -> new unionFind.cluster(3, HashSet(2, 3)),
      3 -> new unionFind.cluster(3, HashSet(2, 3)),
      4 -> new unionFind.cluster(4, HashSet(4)),
      5 -> new unionFind.cluster(5, HashSet(5)))
    )
  }

  it should "perform find" in  {
    unionFind.union(2,3)
    unionFind.find(2,3) should be (true)
    unionFind.find(3,4) should be (false)

  }

}

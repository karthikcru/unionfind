package unionfind
import org.scalatest.FreeSpec
import org.scalatest.Matchers._


class UnionFindSpec extends FreeSpec {


"unionfind" - {
  "do find correctly" in {
    val elements = List(1,2,3,4,5)
    val unionFind = new UnionFind(elements)

    unionFind.addElements(List(1, 2, 3, 4, 5))
    unionFind.isOfSameCluster(2, 3) should be(false)
  }

  "do union correctly when both elements are root" in {
    val elements = List(1,2,3,4,5)
    val unionFind = new UnionFind(elements)

    unionFind.union(2, 3)
    unionFind.isOfSameCluster(2, 3) should be(true)
  }

  "do union correctly when one of the elements is non root" in {
    val elements = List(1,2,3,4,5)
    val unionFind = new UnionFind(elements)
    unionFind.union(2, 3)
    unionFind.union(2,4)
    unionFind.isOfSameCluster(2,4)  should be (true)
  }

  "do union correctly when bothe elements are not root" in {
    val elements = List(1,2,3,4,5)
    val unionFind = new UnionFind(elements)
    unionFind.union(2,3)
    unionFind.union(1,4)
    unionFind.union(1,2)
//    unionFind.union(4,5)
    println(unionFind.items)
    unionFind.isOfSameCluster(2,3) should be (true)
//    unionFind.find(4,5) should be (true)
//    unionFind.find(1,4) should be (true)
  }

  "do union find for pair wise elements " in {
    val elements = (0 to 10).toList
    val unionFind = new UnionFind(elements)
    unionFind.union(0, 1)
    println(unionFind.items)
    unionFind.union(2, 1)
    println(unionFind.items)
    unionFind.union(1, 5)
    println(unionFind.items)
    unionFind.union(4, 6)
    println(unionFind.items)
    unionFind.union(4, 1)
    println(unionFind.items)
    unionFind.union(7, 4)
    println(unionFind.items)
    unionFind.union(7, 5)
    println(unionFind.items)
    unionFind.union(9, 6)
    println(unionFind.items)

    unionFind.isOfSameCluster(4,9) should be(true)
    print("amma")
    unionFind.isOfSameCluster(0,2) should be(true)
    print("ammaa")
    unionFind.isOfSameCluster(1,9) should be(true)
    print("ammaaa")
  }
}

}

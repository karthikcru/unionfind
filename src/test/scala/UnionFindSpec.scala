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
    unionFind.isOfSameCluster(2,3) should be (true)

  }

  "do union find for pair wise elements " in {
    val elements = (0 to 10).toList
    val unionFind = new UnionFind(elements)

    unionFind.union(0, 1)
    unionFind.union(2, 1)
    unionFind.union(1, 5)
    unionFind.union(4, 9)
    unionFind.union(7, 4)
    unionFind.union(7, 5)
    unionFind.union(9, 6)
    unionFind.isOfSameCluster(4,9) should be(true)
    unionFind.isOfSameCluster(0,2) should be(true)
    unionFind.isOfSameCluster(1,10) should be(false)

  }

  "check whether a list of elements belong to the same cluster" in{
    val elements = (0 to 10).toList
    val unionFind = new UnionFind(elements)

    unionFind.union(0, 1)
    unionFind.union(2, 1)
    unionFind.union(1, 5)
    unionFind.union(4, 9)
    unionFind.union(7, 4)
    unionFind.union(7, 5)
    unionFind.union(9, 6)
    unionFind.checkIfSameCluster(List(0,1,2,10)) should be (false)
    unionFind.checkIfSameCluster(List(0,1,2,4,9)) should be (true)

  }

  "get all the elements in a cluster" in {
    val elements = (0 to 10).toList
    val unionFind = new UnionFind(elements)

    unionFind.union(0, 1)
    unionFind.union(2, 1)
    unionFind.union(1, 5)
    unionFind.union(4, 9)
    unionFind.union(7, 4)
    unionFind.union(7, 5)
    unionFind.union(9, 6)
    unionFind.getAllElements(1) should be (Set(5, 6, 9, 2, 7, 4, 1, 0))

  }

  "get all the clusters" in {
    val elements = (0 to 10).toList
    val unionFind = new UnionFind(elements)

    unionFind.union(0, 1)
    unionFind.union(2, 1)
    unionFind.union(1, 5)
    unionFind.union(4, 9)
    unionFind.union(7, 4)
    unionFind.union(7, 5)
    unionFind.union(9, 6)
    unionFind.getAllClusters().toSet should be (Set(10,7,3,8))
    unionFind.getAllClustersWithVals() should be  (Set(Set(10), Set(0, 5, 1, 6, 9, 2, 7, 4), Set(3), Set(8)))

  }
 }

}

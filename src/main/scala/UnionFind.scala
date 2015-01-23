package unionfind

import scala.collection.immutable.{HashMap, HashSet}
class UnionFind [A](elements:List[A]) {
  var el = new HashMap[A,cluster]
  for (a <- elements  if a!=null  )
    el = el + (a -> new cluster(a,HashSet(a)))


  def removeFromOldAndAddToNew(a:cluster,b:cluster): Unit ={
    b.set.foreach(element=> {el=el-element+(element->a)})
    a.set.foreach(element=> {el=el.+(element->a) })

  }

  def makeSet(element:A): Unit = {
    el=el.+(element->new cluster(element,HashSet(element)))
  }

  def addToCluster(element:A,clust:A): Unit ={
    if(el.get(clust)==None)
      makeSet(element)
    else
      union(element,clust)
  }

  def getCluster(a:A) = {
    el.get(a).get.set
  }

  def union(a:A,b:A):cluster = {
    val first:cluster = el.get(a).get
    val second:cluster = el.get(b).get
    if (first.set.contains(b)||second.set.contains(a))
      return first

    if(first.set.size>second.set.size) {
      removeFromOldAndAddToNew(first.copy(set = first.set ++ second.set),second)
      println("hello here")
      first.copy(set = first.set ++ second.set)
    }

    else{
      removeFromOldAndAddToNew(second.copy(set= second.set++first.set),first)
      println("hello there")
      println(second.copy(set= second.set++first.set))
      println("i am first"+first)
      second.copy(set= second.set++first.set)
    }
  }

  def find(a: A,b:A):Boolean= {
    el.get(a).get.set.contains(b)
  }


  case class cluster(e: A,set:HashSet[A]) {
    set.apply(e)
    def addElement(ele: A) = {
      this.copy(e = ele)
    }
  }
}

case class cluster[A](e: A,set:HashSet[A]) {
  set.apply(e)
  def addElement(ele: A) = {
    this.copy(e = ele)
  }
}



package unionfind
class UnionFind [A](elements:List[A]) {
  var items = Map[A, Option[A]]()
  addElements(elements)
  //add all the elements to the cluster
  def addElements(item: List[A]): Unit = {
    item.map(a => {
      items = items.+(a -> Some(a))
    })
  }
  //joins two clusters together
  def union(a: A, b: A) =  {
   require(items.contains(a),items.contains(b))
    val rootOfA = Option(find(a))
    val rootOfB = find(b)
    items = items + (a->rootOfA) + (rootOfB->rootOfA) + (b->rootOfA)
  }
  //checks if two elements are of the same cluster
  def isOfSameCluster(a: A, b: A): Boolean = {
    require(items.contains(a), items.contains(b))
    find(a) == find(b)
  }
  //finds the respresentative of an element
  def find(a:A):A =  items(a) match{
    case Some(x) => if (x!=a) find(x) else a
  }
  //gets all the elements of the root starting from the root of the cluster(representative of the cluster)
  def getAllElementsFromRoot(a:A):Set[A] = {
    val all = items.filterKeys(keys => items(keys)== Option(a)).map(clusters => clusters._1.asInstanceOf[A]).toList
    (all ++ (if(all!=List()) all.filter(ele => ele!=a).flatMap(ele=>getAllElementsFromRoot(ele)).toList else List())).toSet
  }
 //gets root of element and gets all the elements from the roo
  def getAllElements(a:A):Set[A] = {
    getAllElementsFromRoot(find(a))
  }
  //checks if the list of elements belong to the same cluster
  def checkIfSameCluster(list: List[A]):Boolean = {
    list.tail.forall(ab => find(ab) == find(list.head))
  }
  //gets all teh cluster representatives
  def getAllClusters():Set[A] = {
    items.filterKeys(elements => items(elements)==Option(elements)).map(ele => ele._1.asInstanceOf[A]).toSet
  }

  def getAllClustersWithVals():Set[Set[A]] = {//gets all the clusters
    getAllClusters.map(ele => getAllElementsFromRoot(ele)).toSet
  }
  

}



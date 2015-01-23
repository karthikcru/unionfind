package unionfind
class UnionFind [A](elements:List[A]) {
  var items = Map[A, Option[A]]()
  addElements(elements)

  def addElements(item: List[A]): Unit = {
    item.map(a => {
      items = items.+(a -> None)
    })
  }

  def pathCompression(a: A, b: A): Map[A, Option[A]] = {
    items.filterKeys(keys => items(keys) == Option(a)).map(ele => (ele._1, Option(b)))
  }

  def union(a: A, b: A) = (items(a), items(b)) match {
    case (None, Some(x)) => items = items.+(a -> Option(x)) ++ pathCompression(a, x)
    case (Some(x), Some(y)) if !isOfSameCluster(a, b) => items = items + (x -> Option(y)) ++ pathCompression(x, y)

    case (Some(x), None) => items = items + (x -> Option(b)) ++ pathCompression(x, b)
    case (None, None) => items = items.+(a -> Option(b)) ++ pathCompression(a, b)
  }

  def isOfSameCluster(a: A, b: A): Boolean = {
    require(items.contains(a), items.contains(b))
    items(a) == Option(b) || items(b) == Option(a) || items(a) == items(b) && !(items(a) == None && items(b) == None)
  }

  def find(a:A)
  {
    require(items.contains(a))
    items(a)
  }

  def checkIfSameCluster(list: List[A])
  {
    val a= items(list.head)
    list.foreach(ab=> if(items(ab)!=a)
    return false)

  }

}



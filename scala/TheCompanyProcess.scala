class TheCompanyProcess
object TheCompanyProcess {
  def main(args: Array[String]) {
    val employees = List("neal","s","stu","j","rich","bob","aiden","j","ethan",
                          "liam","mason","noah","lucas","jacob","jayden","jack")
    println(cleanNames(employees))
  }

  def cleanNames(employees: List[String]): String = {
    employees
      // 병렬 처리
      .par
      .filter(_.length() > 1)
      .map(_.capitalize)
      .reduce(_ + "," + _)
  }
}

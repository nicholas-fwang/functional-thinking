class TheCompanyProcess {
  static void main (String[] args) {
      def listOfNames = ["neal","s","stu","j","rich","bob","aiden","j",
      "ethan","liam","mason","noah","lucas","jacob","jayden","jack"];

      println cleanUpNames(listOfNames)
  }

  public static String cleanUpNames(listOfNames) {
    listOfNames
      .findAll { it.length() > 1 }
      .collect { it.capitalize() }
      .join ','
  }
}

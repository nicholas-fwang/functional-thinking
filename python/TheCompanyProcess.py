class TheCompanyProcess:
    def __init__(self, listOfNames):
        self.listOfNames = listOfNames

    def cleanNames(self):
        result = ""
        for name in self.listOfNames :
            if len(name) > 1 :
                result += self.capitalizeString(name)
                result += ","
        return result[:-1]

    def cleanNames_f(self):
        names = self.listOfNames
        names = list(filter(lambda name: len(name) > 1, names))
        names = list(map(lambda name: self.capitalizeString(name), names))
        result = reduce((lambda x,y: x+","+y), names)
        return result

    def capitalizeString(self, s):
        return s[0].upper() + s[1:]

def main():
    process = TheCompanyProcess(["neal","s","stu","j","rich","bob","aiden","j","ethan",
                            "liam","mason","noah","lucas","jacob","jayden","jack"])
    print "----- oriented python -----"
    print process.cleanNames()
    print "----- functional python -----"
    print process.cleanNames_f()

if __name__ == "__main__": main()

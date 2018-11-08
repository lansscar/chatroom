while(true) {
        def socket = new Socket('localhost', 5000)
        def console = System.console()
        def rmsg
        def smsg
        if (console) {
                smsg = console.readLine(">>Send: ")
                socket.withStreams { input, output ->
                        output << "${smsg}\n"
                        rmsg = input.newReader().readLine()
                }
                println ">>Received: ${rmsg}"
        }
}

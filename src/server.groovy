def socketServer = new ServerSocket(5000)

while(true) {
        socketServer.accept { socket ->
                socket.withStreams { input, output ->
                        def rmsg = input.newReader().readLine()
                        def smsg = rmsg
                        output << "$smsg"
                        println ">> Received: ${rmsg}"
                }
        }
}

library dart_style.src.io;

bool processDirectory(FormatterOptions options, Directory directory) {
    mediator.expectMsg(PubSubMediator.Publish(
                a(b(className[MessageEvent],
                              MessageAdded(flowName, Message("Akka rocks!", time))))));
}

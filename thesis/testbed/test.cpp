//                                                                             |
int main(int argc, char const* argv[])
{
  mediator.expectMsg(aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa, PubSubMediator.Publish(
            className[MessageEvent],
                MessageAdded(flowName, Message("Akka rocks!", time))
        ));
  return 0;
}

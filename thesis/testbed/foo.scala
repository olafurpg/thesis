// column 80                                                                   |
object Foo {
  aaaaaaaaaatoJson(
      balancingCharges.map(
          balancingCharge =>
            halResource(
                obj(),
                Seq(HalLink(
                        "self",
                        selfEmploymentSummaryTypeIdHref(
                            saUtr,
                            taxYear,
                            seId,
                            BalancingChargesSummaryType,
                            balancingCharge.id.get))))))
}

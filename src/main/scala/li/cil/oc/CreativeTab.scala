package li.cil.oc

import li.cil.oc.common.init.Items
import net.minecraft.creativetab.CreativeTabs

object CreativeTab extends CreativeTabs(CreativeTabs.getNextID, "OpenComputers") {
  private lazy val configuredItems = Array(
    Items.createOpenOS(),
    Items.createLuaBios(),
    Items.createConfiguredDrone(),
    Items.createConfiguredMicrocontroller(),
    Items.createConfiguredRobot()
  )

  override def getTabIconItem = api.Items.get("case1").item()

  override def getTranslatedTabLabel = getTabLabel

  override def displayAllReleventItems(list: java.util.List[_]): Unit = {
    super.displayAllReleventItems(list)
    // Workaround for MC's untyped lists...
    def add[T](list: java.util.List[T], value: Any) = list.add(value.asInstanceOf[T])
    configuredItems.foreach(add(list, _))
  }
}

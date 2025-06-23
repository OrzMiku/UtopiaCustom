package show.miku;

import net.fabricmc.api.ModInitializer;
import show.miku.item.UtopiaCustomItems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UtopiaCustom implements ModInitializer {
	public static final String MOD_ID = "utopia_custom";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		UtopiaCustomItems.init();
		LOGGER.info("UtupiaCustom Initialized");
	}
}
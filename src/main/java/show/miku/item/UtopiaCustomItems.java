package show.miku.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import show.miku.UtopiaCustom;

public class UtopiaCustomItems {
    public static final RegistryKey<ItemGroup> UTOPIA_CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(UtopiaCustom.MOD_ID, "item_group"));
    public static final ItemGroup UTOPIA_CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
        .icon(() -> UtopiaCustomItems.LOTTERY_TICKET.getDefaultStack())
        .displayName(Text.translatable("itemGroup." + UtopiaCustom.MOD_ID))
        .build();

    public static final Item LOTTERY_TICKET = register("lottery_ticket", new Item(new FabricItemSettings()));
    public static final Item MONEY = register("money", new Item(new FabricItemSettings()));
    public static final Item MONEY_2 = register("money_2", new Item(new FabricItemSettings()));
    public static final Item MONEY_5 = register("money_5", new Item(new FabricItemSettings()));
    public static final Item MONEY_10 = register("money_10", new Item(new FabricItemSettings()));
    public static final Item MONEY_20 = register("money_20", new Item(new FabricItemSettings()));
    public static final Item MONEY_50 = register("money_50", new Item(new FabricItemSettings()));
    public static final Item MONEY_100 = register("money_100", new Item(new FabricItemSettings()));
    public static final Item MONEY_500 = register("money_500", new Item(new FabricItemSettings()));
    public static final Item MONEY_1000 = register("money_1000", new Item(new FabricItemSettings()));
    public static <T extends Item> T register(String id, T item) {
        Identifier identifier = Identifier.of(UtopiaCustom.MOD_ID, id);
        Registry.register(Registries.ITEM, identifier, item);
        return item;
    }

    // Register fuel
    public static void registerFuel() {
        FuelRegistry.INSTANCE.add(UtopiaCustomItems.LOTTERY_TICKET, 20);
        FuelRegistry.INSTANCE.add(UtopiaCustomItems.MONEY, 20);
        FuelRegistry.INSTANCE.add(UtopiaCustomItems.MONEY_2, 20);
        FuelRegistry.INSTANCE.add(UtopiaCustomItems.MONEY_5, 20);
        FuelRegistry.INSTANCE.add(UtopiaCustomItems.MONEY_10, 20);
        FuelRegistry.INSTANCE.add(UtopiaCustomItems.MONEY_20, 20);
        FuelRegistry.INSTANCE.add(UtopiaCustomItems.MONEY_50, 20);
        FuelRegistry.INSTANCE.add(UtopiaCustomItems.MONEY_100, 20);
        FuelRegistry.INSTANCE.add(UtopiaCustomItems.MONEY_500, 20);
        FuelRegistry.INSTANCE.add(UtopiaCustomItems.MONEY_1000, 20);
    }

    // Register items
    public static void registerItems() {
        UtopiaCustom.LOGGER.info("Registering Items for " + UtopiaCustom.MOD_ID);
        // Register fuel for items
        registerFuel();
    }

    // Register the item group
    public static void registerItemGroup() {
        UtopiaCustom.LOGGER.info("Registering Item Group for " + UtopiaCustom.MOD_ID);
        Registry.register(Registries.ITEM_GROUP, UTOPIA_CUSTOM_ITEM_GROUP_KEY, UTOPIA_CUSTOM_ITEM_GROUP);
        // Add items to the item group
        ItemGroupEvents.modifyEntriesEvent(UTOPIA_CUSTOM_ITEM_GROUP_KEY).register(entries -> {
            entries.add(UtopiaCustomItems.LOTTERY_TICKET);
            entries.add(UtopiaCustomItems.MONEY);
            entries.add(UtopiaCustomItems.MONEY_2);
            entries.add(UtopiaCustomItems.MONEY_5);
            entries.add(UtopiaCustomItems.MONEY_10);
            entries.add(UtopiaCustomItems.MONEY_20);
            entries.add(UtopiaCustomItems.MONEY_50);
            entries.add(UtopiaCustomItems.MONEY_100);
            entries.add(UtopiaCustomItems.MONEY_500);
            entries.add(UtopiaCustomItems.MONEY_1000);
        });
    }

    // Initialize the items and item group
    public static void init() {
        registerItems();
        registerItemGroup();
    }
}

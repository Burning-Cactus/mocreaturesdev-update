package drzhark.mocreatures.registry;

import drzhark.mocreatures.MoCConstants;
import drzhark.mocreatures.dimension.WyvernLairBiome;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(MoCConstants.MOD_ID)
public class MoCBiomes {

    public static final Biome WYVERNBIOME = new WyvernLairBiome(new Biome.Builder().setBaseHeight(0.3F));

    @Mod.EventBusSubscriber(modid = MoCConstants.MOD_ID)
    public static class RegistrationHandler {

        /**
         * Register this mod's {@link Biome}s.
         *
         * @param event The event
         */
        @SubscribeEvent
        public static void registerBiomes(final RegistryEvent.Register<Biome> event) {
            final IForgeRegistry<Biome> registry = event.getRegistry();
            registerBiome(registry, WYVERNBIOME, "wyvernbiome", BiomeManager.BiomeType.WARM, 1000, Type.FOREST, Type.END);
        }

        private static <T extends Biome> void registerBiome(final IForgeRegistry<Biome> registry, final T biome, final String biomeName, final BiomeManager.BiomeType biomeType, final int weight, final BiomeDictionary.Type... types) {
            registry.register(biome.setRegistryName(MoCConstants.MOD_ID, biomeName));
            BiomeDictionary.addTypes(biome, types);
            // Avoid registering with BiomeManager so wyvern lair does not generate in other dimensions
            //BiomeManager.addBiome(biomeType, new BiomeManager.BiomeEntry(biome, weight));
        }

    }
}

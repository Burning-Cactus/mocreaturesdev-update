package drzhark.mocreatures.data.datagen.lang;

import drzhark.mocreatures.MoCItemGroup;
import drzhark.mocreatures.registry.MoCBlocks;
import drzhark.mocreatures.registry.MoCEntities;
import drzhark.mocreatures.registry.MoCItems;
import net.minecraft.data.DataGenerator;

public class MoCEnUSLangProvider extends MoCLangProvider {
    public MoCEnUSLangProvider(DataGenerator gen) {
        super(gen, "en_us");
    }

    @Override
    protected void addTranslations() {
        //Blocks
        add(MoCBlocks.WYVERN_DIRT, "Wyvern Dirt");
        add(MoCBlocks.WYVERN_GRASS, "Wyvern Grass");
        add(MoCBlocks.WYVERN_LOG, "Wyvern Log");
        add(MoCBlocks.WYVERN_STONE, "Wyvern Stone");
        add(MoCBlocks.WYVERN_PLANKS, "Wyvern Wooden Planks");
        add(MoCBlocks.WYVERN_TALLGRASS, "Wyvern Tallgrass");
        add(MoCBlocks.WYVERN_LEAVES, "Wyvern Leaves");
        add(MoCBlocks.OGRE_DIRT, "Ogre Dirt");
        add(MoCBlocks.OGRE_GRASS, "Ogre Grass");
        add(MoCBlocks.OGRE_LEAVES, "Ogre Leaves");
        add(MoCBlocks.OGRE_LOG, "Ogre Log");
        add(MoCBlocks.OGRE_STONE, "Ogre Stone");
        add(MoCBlocks.OGRE_PLANKS, "Ogre Wooden Planks");
        add(MoCBlocks.OGRE_TALLGRASS, "Ogre Tallgrass");

        //Entities
        add(MoCEntities.BIRD, "Bird");
        add(MoCEntities.BLACK_BEAR, "Black");
        add(MoCEntities.BOAR, "Boar");
        add(MoCEntities.BUNNY, "Bunny");
        add(MoCEntities.CROCODILE, "Crocodile");
        add(MoCEntities.DEER, "Deer");
        add(MoCEntities.DUCK, "Duck");
        add(MoCEntities.ELEPHANT, "Elephant");
        add(MoCEntities.ENT, "Ent");
        add(MoCEntities.FOX, "Fox");
        add(MoCEntities.GOAT, "Goat");
        add(MoCEntities.GRIZZLY_BEAR, "Grizzly Bear");
        add(MoCEntities.KITTY, "Kitty");
        add(MoCEntities.KOMODO_DRAGON, "Komodo Dragon");
        add(MoCEntities.LEOGER, "Leoger");
        add(MoCEntities.LEOPARD, "Leopard");
        add(MoCEntities.LIARD, "Liard");
        add(MoCEntities.LION, "Lion");
        add(MoCEntities.LIGER, "Liger");
        add(MoCEntities.LITHER, "Lither");
        add(MoCEntities.MANTICORE_PET, "Manticore Pet");
        add(MoCEntities.MOLE, "Mole");
        add(MoCEntities.MOUSE, "Mouse");
        add(MoCEntities.OSTRICH, "Ostrich");
        add(MoCEntities.PANDA_BEAR, "Panda Bear");
        add(MoCEntities.PANTHARD, "Panthard");
        add(MoCEntities.PANTHER, "Panther");
        add(MoCEntities.PANTHGER, "Panthger");
        add(MoCEntities.POLAR_BEAR, "Polar Bear");
        add(MoCEntities.RACCOON, "Raccoon");
        add(MoCEntities.PET_SCORPION, "Pet Scorpion");
        add(MoCEntities.SNAKE, "Snake");
        add(MoCEntities.TIGER, "Tiger");
        add(MoCEntities.TURTLE, "Turtle");
        add(MoCEntities.TURKEY, "Turkey");
        add(MoCEntities.WILDHORSE, "Wild Horse");
        add(MoCEntities.WYVERN, "Wyvern");
        add(MoCEntities.BIG_GOLEM, "Big Golem");
        add(MoCEntities.CAVE_OGRE, "Cave Ogre");
        add(MoCEntities.FIRE_OGRE, "Fire Ogre");
        add(MoCEntities.GREEN_OGRE, "Green Ogre");
        add(MoCEntities.FLAME_WRAITH, "Flame Wraith");
        add(MoCEntities.HORSEMOB, "HorseMob");
        add(MoCEntities.HELLRAT, "Hell Rat");
        add(MoCEntities.MANTICORE, "Manticore");
        add(MoCEntities.MINI_GOLEM, "Mini Golem");
        add(MoCEntities.RAT, "Rat");
        add(MoCEntities.SILVER_SKELETON, "Silver Skeleton");
        add(MoCEntities.SCORPION, "Scorpion");
        add(MoCEntities.WEREWOLF, "Werewolf");
        add(MoCEntities.WRAITH, "Wraith");
        add(MoCEntities.WWOLF, "WWolf"); //Could also be called Wild Wolf maybe?
        add(MoCEntities.ANCHOVY, "Anchovy");
        add(MoCEntities.ANGELFISH, "Angelfish");
        add(MoCEntities.ANGLER, "Angler");
        add(MoCEntities.BASS, "Bass");
        add(MoCEntities.CLOWNFISH, "Clownfish");
        add(MoCEntities.COD, "Cod");
        add(MoCEntities.DOLPHIN, "Dolphin");
        add(MoCEntities.FISHY, "Fishy");
        add(MoCEntities.GOLDFISH, "Goldfish");
        add(MoCEntities.HIPPOTANG, "Hippo Tang");
        add(MoCEntities.JELLYFISH, "Jellyfish");
        add(MoCEntities.MANDERIN, "Manderin");
        add(MoCEntities.PIRANHA, "Piranha");
        add(MoCEntities.SALMON, "Salmon");
        add(MoCEntities.MANTARAY, "Manta Ray");
        add(MoCEntities.SHARK, "Shark");
        add(MoCEntities.STINGRAY, "Sting Ray");
        add(MoCEntities.ANT, "Ant");
        add(MoCEntities.BEE, "Bee");
        add(MoCEntities.BUTTERFLY, "Butterfly");
        add(MoCEntities.CRAB, "Crab");
        add(MoCEntities.CRICKET, "Cricket");
        add(MoCEntities.DRAGONFLY, "Dragonfly");
        add(MoCEntities.FIREFLY, "Firefly");
        add(MoCEntities.FLY, "Fly");
        add(MoCEntities.MAGGOT, "Maggot");
        add(MoCEntities.SNAIL, "Snail");
        add(MoCEntities.ROACH, "Roach");

        //Items
        add(MoCItems.RAT_RAW, "Raw Rat");
        add(MoCItems.RAT_COOKED, "Cooked Rat");
        add(MoCItems.RAT_BURGER, "Rat Burger");
        add(MoCItems.TURKEY_RAW, "Raw Turkey");
        add(MoCItems.TURKEY_COOKED, "Cooked Turkey");
        add(MoCItems.CRAB_RAW, "Raw Crab");
        add(MoCItems.CRAB_COOKED, "Cooked Crab");
        add(MoCItems.OSTRICH_RAW, "Raw Ostrich");
        add(MoCItems.OSTRICH_COOKED, "Cooked Ostrich");
        add(MoCItems.TURTLE_RAW, "Raw Turtle");
        add(MoCItems.TURTLE_SOUP, "Turtle Soup");
        add(MoCItems.MOCEGG, "Egg");
        add(MoCItems.OMELET, "Omelet");
        add(MoCItems.WHIP, "Whip");
        add(MoCItems.MEDALLION, "Medallion");
        add(MoCItems.HORSESADDLE, "Crafted Saddle");
        add(MoCItems.ESSENCEDARKNESS, "Essence of Darkness");
        add(MoCItems.ESSENCEUNDEAD, "Essence of Undead");
        add(MoCItems.ESSENCEFIRE, "Essence of Fire");
        add(MoCItems.ESSENCELIGHT, "Essence of Light");
        add(MoCItems.PETAMULET, "Pet Amulet");
        add(MoCItems.PETAMULETFULL, "Pet Amulet");
        add(MoCItems.AMULETGHOST, "Ghost Amulet");
        add(MoCItems.AMULETGHOSTFULL, "Ghost Amulet");
        add(MoCItems.AMULETBONE, "Bone Amulet");
        add(MoCItems.AMULETBONEFULL, "Bone Amulet");
        add(MoCItems.AMULETFAIRY, "Fairy Amulet");
        add(MoCItems.AMULETFAIRYFULL, "Fairy Amulet");
        add(MoCItems.AMULETPEGASUS, "Pegasus Amulet");
        add(MoCItems.AMULETPEGASUSFULL, "Pegasus Amulet");
        add(MoCItems.WOOLBALL, "Wool Ball");
        add(MoCItems.RECORDSHUFFLE, "Record Shuffle");
        add(MoCItems.SCORPHELMETCAVE, "Cave Scorpion Helmet");
        add(MoCItems.SCORPHELMETDIRT, "Scorpion Helmet");
        add(MoCItems.SCORPHELMETFROST, "Frost Scorpion Helmet");
        add(MoCItems.SCORPHELMETNETHER, "Nether Scorpion Helmet");
        add(MoCItems.SCORPPLATECAVE, "Cave Scorpion Chestplate");
        add(MoCItems.SCORPPLATEDIRT, "Scorpion Chestplate");
        add(MoCItems.SCORPPLATEFROST, "Frost Scorpion Chestplate");
        add(MoCItems.SCORPPLATENETHER, "Nether Scorpion Chestplate");
        add(MoCItems.SCORPLEGSCAVE, "Cave Scorpion Leggings");
        add(MoCItems.SCORPLEGSDIRT, "Scorpion Leggings");
        add(MoCItems.SCORPLEGSFROST, "Frost Scorpion Leggings");
        add(MoCItems.SCORPLEGSNETHER, "Nether Scorpion Leggings");
        add(MoCItems.SCORPBOOTSCAVE, "Cave Scorpion Boots");
        add(MoCItems.SCORPBOOTSDIRT, "Scorpion Boots");
        add(MoCItems.SCORPBOOTSFROST, "Frost Scorpion Boots");
        add(MoCItems.SCORPBOOTSNETHER, "Nether Scorpion Boots");
        add(MoCItems.SCROLLOFFREEDOM, "Scroll of Freedom");
        add(MoCItems.SCROLLOFOWNER, "Scroll of Ownership");
        add(MoCItems.SCROLLOFSALE, "Scroll of Sale");
        add(MoCItems.FISHNET, "Fishnet");
        add(MoCItems.FISHNETFULL, "Fishnet");
        add(MoCItems.HAYSTACK, "Hay Stack");
        add(MoCItems.HELMETCROC, "Croc Helmet");
        add(MoCItems.PLATECROC, "Croc Chestplate");
        add(MoCItems.LEGSCROC, "Croc Leggings");
        add(MoCItems.BOOTSCROC, "Croc Boots");
        add(MoCItems.HELMETFUR, "Fur Helmet");
        add(MoCItems.CHESTFUR, "Fur Chestplate");
        add(MoCItems.LEGSFUR, "Fur Leggings");
        add(MoCItems.BOOTSFUR, "Fur Boots");
        add(MoCItems.HELMETHIDE, "Hide Helmet");
        add(MoCItems.CHESTHIDE, "Hide Chestplate");
        add(MoCItems.LEGSHIDE, "Hide Leggings");
        add(MoCItems.BOOTSHIDE, "Hide Boots");
        add(MoCItems.SUGARLUMP, "Sugar Lump");
        add(MoCItems.ANIMALHIDE, "Animal Hide");
        add(MoCItems.HIDECROC, "Croc Hide");
        add(MoCItems.CHITIN, "Chitin");
        add(MoCItems.CHITINCAVE, "Cave Chitin");
        add(MoCItems.CHITINFROST, "Frost Chitin");
        add(MoCItems.CHITINNETHER, "Nether Chitin");
        add(MoCItems.FUR, "Fur");
        add(MoCItems.ELEPHANTGARMENT, "Elephant Garment");
        add(MoCItems.ELEPHANTHARNESS, "Elephant Harness");
        add(MoCItems.ELEPHANTHOWDAH, "Elephant Howdah");
        add(MoCItems.ELEPHANTCHEST, "Elephant Chest");
        add(MoCItems.MAMMOTHPLATFORM, "Mammoth Platform");
        add(MoCItems.TUSKSWOOD, "Wooden Tusks");
        add(MoCItems.TUSKSIRON, "Iron Tusks");
        add(MoCItems.TUSKSDIAMOND, "Diamond Tusks");
        add(MoCItems.LITTERBOX, "Litterbox");
        // Kittybed translation
        add(MoCItems.PETFOOD, "Pet Food");
        add(MoCItems.SILVERSWORD, "Silver Sword");
        add(MoCItems.SCORPSWORDDIRT, "Scorpion Sword");
        add(MoCItems.SCORPSWORDCAVE, "Cave Scorpion Sword");
        add(MoCItems.SCORPSWORDNETHER, "Nether Scorpion Sword");
        add(MoCItems.SCORPSTINGDIRT, "Scorpion Sting");
        add(MoCItems.SCORPSTINGCAVE, "Cave Scorpion Sting");
        add(MoCItems.SCORPSTINGFROST, "Frost Scorpion Sting");
        add(MoCItems.SCORPSTINGNETHER, "Nether Scorpion Sting");
        add(MoCItems.SHARKSWORD, "Shark Sword");
        add(MoCItems.SAI, "Sai");
        add(MoCItems.BO, "Bo");
        add(MoCItems.NUNCHAKU, "Nunchaku");
        add(MoCItems.KATANA, "Katana");
        add(MoCItems.UNICORNHORN, "Unicorn");
        add(MoCItems.BIGCATCLAW, "Big Cat Claw");
        add(MoCItems.SHARKTEETH, "Shark Tooth");
        add(MoCItems.STAFFPORTAL, "Portal Staff");
        add(MoCItems.STAFFTELEPORT, "Telportation Staff");
        add(MoCItems.BUILDERHAMMER, "Builder Hammer");
        add(MoCItems.HORSEARMORCRYSTAL, "Crystal Horse Armor");
        add(MoCItems.HEARTDARKNESS, "Heart of Darkness");
        add(MoCItems.HEARTFIRE, "Heart of Fire");
        add(MoCItems.HEARTUNDEAD, "Heart of Undead");

        add(MoCItems.BIRD_SPAWN_EGG, "Bird Spawn Egg");
        add(MoCItems.BLACK_BEAR_SPAWN_EGG, "Black Bear Spawn Egg");
        add(MoCItems.BOAR_SPAWN_EGG, "Boar Spawn Egg");
        add(MoCItems.BUNNY_SPAWN_EGG, "Bunny Spawn Egg");
        add(MoCItems.CROCODILE_SPAWN_EGG, "Crocodile Spawn Egg");
        add(MoCItems.DEER_SPAWN_EGG, "Deer Spawn Egg");
        add(MoCItems.DUCK_SPAWN_EGG, "Duck Spawn Egg");
        add(MoCItems.ELEPHANT_SPAWN_EGG, "Elephant Spawn Egg");
        add(MoCItems.ENT_SPAWN_EGG, "Ent Spawn Egg");
        add(MoCItems.FOX_SPAWN_EGG, "Fox Spawn Egg");
        add(MoCItems.GOAT_SPAWN_EGG, "Goat Spawn Egg");
        add(MoCItems.GRIZZLY_BEAR_SPAWN_EGG, "Grizzly Bear Spawn Egg");
        add(MoCItems.KITTY_SPAWN_EGG, "Kitty Spawn Egg");
        add(MoCItems.KOMODO_DRAGON_SPAWN_EGG, "Komodo Dragon Spawn Egg");
        add(MoCItems.LEOGER_SPAWN_EGG, "Leoger Spawn Egg");
        add(MoCItems.LEOPARD_SPAWN_EGG, "Leopard Spawn Egg");
        add(MoCItems.LIARD_SPAWN_EGG, "Liard Spawn Egg");
        add(MoCItems.LION_SPAWN_EGG, "Lion Spawn Egg");
        add(MoCItems.LIGER_SPAWN_EGG, "Liger Spawn Egg");
        add(MoCItems.LITHER_SPAWN_EGG, "Lither Spawn Egg");
        add(MoCItems.MOLE_SPAWN_EGG, "Mole Spawn Egg");
        add(MoCItems.MOUSE_SPAWN_EGG, "Mouse Spawn Egg");
        add(MoCItems.OSTRICH_SPAWN_EGG, "Ostrich Spawn Egg");
        add(MoCItems.PANDA_BEAR_SPAWN_EGG, "Panda Bear Spawn Egg");
        add(MoCItems.PANTHARD_SPAWN_EGG, "Panthard Spawn Egg");
        add(MoCItems.PANTHER_SPAWN_EGG, "Panther Spawn Egg");
        add(MoCItems.PANTHGER_SPAWN_EGG, "Panthger Spawn Egg");
        add(MoCItems.POLAR_BEAR_SPAWN_EGG, "Polar Bear Spawn Egg");
        add(MoCItems.RACCOON_SPAWN_EGG, "Raccoon Spawn Egg");
        add(MoCItems.SNAKE_SPAWN_EGG, "Snake Spawn Egg");
        add(MoCItems.TIGER_SPAWN_EGG, "Tiger Spawn Egg");
        add(MoCItems.TURTLE_SPAWN_EGG, "Turtle Spawn Egg");
        add(MoCItems.TURKEY_SPAWN_EGG, "Turkey Spawn Egg");
        add(MoCItems.WILDHORSE_SPAWN_EGG, "WildHorse Spawn Egg");
        add(MoCItems.WYVERN_SPAWN_EGG, "Wyvern Spawn Egg");
        add(MoCItems.BIG_GOLEM_SPAWN_EGG, "Big Golem Spawn Egg");
        add(MoCItems.CAVE_OGRE_SPAWN_EGG, "Cave Ogre Spawn Egg");
        add(MoCItems.FIRE_OGRE_SPAWN_EGG, "Fire Ogre Spawn Egg");
        add(MoCItems.GREEN_OGRE_SPAWN_EGG, "Green Ogre Spawn Egg");
        add(MoCItems.FLAME_WRAITH_SPAWN_EGG, "Flame Wraith Spawn Egg");
        add(MoCItems.HORSEMOB_SPAWN_EGG, "HorseMob Spawn Egg");
        add(MoCItems.HELLRAT_SPAWN_EGG, "Hell Rat Spawn Egg");
        add(MoCItems.MANTICORE_SPAWN_EGG, "Manticore Spawn Egg");
        add(MoCItems.MINI_GOLEM_SPAWN_EGG, "Mini Golem Spawn Egg");
        add(MoCItems.RAT_SPAWN_EGG, "Rat Spawn Egg");
        add(MoCItems.SILVER_SKELETON_SPAWN_EGG, "Silver Skeleton Spawn Egg");
        add(MoCItems.SCORPION_SPAWN_EGG, "Scorpion Spawn Egg");
        add(MoCItems.WEREWOLF_SPAWN_EGG, "Werewolf Spawn Egg");
        add(MoCItems.WRAITH_SPAWN_EGG, "Wraith Spawn Egg");
        add(MoCItems.WWOLF_SPAWN_EGG, "WWolf Spawn Egg"); //Could also be called Wild Wolf maybe?
        add(MoCItems.ANCHOVY_SPAWN_EGG, "Anchovy Spawn Egg");
        add(MoCItems.ANGELFISH_SPAWN_EGG, "Angelfish Spawn Egg");
        add(MoCItems.ANGLER_SPAWN_EGG, "Angler Spawn Egg");
        add(MoCItems.BASS_SPAWN_EGG, "Bass Spawn Egg");
        add(MoCItems.CLOWNFISH_SPAWN_EGG, "Clownfish Spawn Egg");
        add(MoCItems.COD_SPAWN_EGG, "Cod Spawn Egg");
        add(MoCItems.DOLPHIN_SPAWN_EGG, "Dolphin Spawn Egg");
        add(MoCItems.FISHY_SPAWN_EGG, "Fishy Spawn Egg");
        add(MoCItems.GOLDFISH_SPAWN_EGG, "Goldfish Spawn Egg");
        add(MoCItems.HIPPOTANG_SPAWN_EGG, "Hippo Tang Spawn Egg");
        add(MoCItems.JELLYFISH_SPAWN_EGG, "Jellyfish Spawn Egg");
        add(MoCItems.MANDERIN_SPAWN_EGG, "Manderin Spawn Egg");
        add(MoCItems.PIRANHA_SPAWN_EGG, "Piranha Spawn Egg");
        add(MoCItems.SALMON_SPAWN_EGG, "Salmon Spawn Egg");
        add(MoCItems.MANTARAY_SPAWN_EGG, "Manta Ray Spawn Egg");
        add(MoCItems.SHARK_SPAWN_EGG, "Shark Spawn Egg");
        add(MoCItems.STINGRAY_SPAWN_EGG, "Sting Ray Spawn Egg");
        add(MoCItems.ANT_SPAWN_EGG, "Ant Spawn Egg");
        add(MoCItems.BEE_SPAWN_EGG, "Bee Spawn Egg");
        add(MoCItems.BUTTERFLY_SPAWN_EGG, "Butterfly Spawn Egg");
        add(MoCItems.CRAB_SPAWN_EGG, "Crab Spawn Egg");
        add(MoCItems.CRICKET_SPAWN_EGG, "Cricket Spawn Egg");
        add(MoCItems.DRAGONFLY_SPAWN_EGG, "Dragonfly Spawn Egg");
        add(MoCItems.FIREFLY_SPAWN_EGG, "Firefly Spawn Egg");
        add(MoCItems.FLY_SPAWN_EGG, "Fly Spawn Egg");
        add(MoCItems.MAGGOT_SPAWN_EGG, "Maggot Spawn Egg");
        add(MoCItems.SNAIL_SPAWN_EGG, "Snail Spawn Egg");
        add(MoCItems.ROACH_SPAWN_EGG, "Roach Spawn Egg");

        add(MoCItemGroup.TABMOC.getDisplayName().getString(), "Mo' Creatures");
    }
}

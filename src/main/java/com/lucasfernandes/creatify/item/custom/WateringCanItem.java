package com.lucasfernandes.creatify.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.state.BlockState;

public class WateringCanItem extends Item {

    private static int radiusWateringCanEffect;
    private static double successPercentage;

    public WateringCanItem(Properties pProperties, int pRadius, double pSuceessPercentage) {
        super(pProperties);

        // Define o raio de ação do regador
        radiusWateringCanEffect = pRadius;
        successPercentage = pSuceessPercentage;
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        if (!pContext.getLevel().isClientSide()) {
            Player player = pContext.getPlayer();
            Level world = pContext.getLevel();

            if (player == null) {
                return InteractionResult.FAIL;
            }

            BlockPos playerPos = player.blockPosition();

            int radius = WateringCanItem.radiusWateringCanEffect;
            double successPercentage = WateringCanItem.successPercentage;

            for (int x = -radius; x <= radius; x++) {
                for (int y = -radius; y <= radius; y++) {
                    for (int z = -radius; z <= radius; z++) {
                        BlockPos aroundPos = playerPos.offset(x, y, z);
                        BlockState blockState = world.getBlockState(aroundPos);

                        if (blockState.getBlock() instanceof CropBlock || // Verifica se é uma plantação
                                blockState.getBlock() instanceof SaplingBlock || // Verifica se é um broto
                                blockState.getBlock() instanceof StemBlock || // Verifica se é um caule de
                                                                              // abóbora/melancia
                                blockState.getBlock() instanceof AttachedStemBlock) { // Verifica se é um caule
                                                                                      // conectado
                            BonemealableBlock fertilizable = (BonemealableBlock) blockState.getBlock();
                            if (fertilizable.isValidBonemealTarget(world, aroundPos, blockState,
                                    world.isClientSide())) {
                                if (world.random.nextDouble() <= successPercentage) {
                                    fertilizable.performBonemeal((ServerLevel) world, world.random, aroundPos,
                                            blockState);
                                }
                            }
                        }

                    }
                }
            }

            // Reduz a durabilidade do regador
            pContext.getItemInHand().hurtAndBreak(1, player,
                    playerEnt -> player.broadcastBreakEvent(pContext.getHand()));

        }

        return InteractionResult.SUCCESS;
    }

}

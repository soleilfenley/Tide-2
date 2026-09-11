package com.li64.tide.registries.entities.misc.fishing;

import com.li64.tide.Tide;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

//? if >=26.2 {
import com.li64.tide.client.renderer.state.StarArrowRenderState;
//?} else {
/*
import com.li64.tide.registries.entities.misc.StarArrow;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
*/
//?}

//? if >=26.2 {
public class StarArrowModel extends EntityModel<StarArrowRenderState> {
//?} else {
/*
public class StarArrowModel extends EntityModel<StarArrow> {
*/
//?}
        public static final ModelLayerLocation MODEL_LOCATION = new ModelLayerLocation(Tide.resource("star_arrow"), "main");

        //? if >=26.2 {
        public StarArrowModel(ModelPart root) { 
                super(root);
        }
        //?} else {
        /*
        private final ModelPart root;
        public StarArrowModel(ModelPart root) { 
                this.root = root;
        }
        */
        //?}



        public static LayerDefinition createBodyLayer() {
                MeshDefinition mesh = new MeshDefinition();
                PartDefinition root = mesh.getRoot();
        
                root.addOrReplaceChild("1", CubeListBuilder.create().texOffs(0, -4).addBox(0.0F, -5.0F, -5.0F, 0.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 20.5F, 0.0F, 0.0F, 1.5708F, 0.0F));
                root.addOrReplaceChild("2", CubeListBuilder.create().texOffs(0, 16).addBox(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 20.5F, 0.0F, -1.5708F, 1.5708F, -1.5708F));
        
                return LayerDefinition.create(mesh, 32, 32);
        }
        
        //? if >=26.2 {
        @Override
        public void setupAnim(StarArrowRenderState state) {}
        //?} else {
        /*
        @Override
        public void setupAnim(StarArrow entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
        */
        //?}

        //? if >=26.2 {
        //?} elif >=1.21 {
        /*
        @Override
        public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
                this.root.render(poseStack, buffer, packedLight, packedOverlay, color);
        }
        */
        //?} else {
        /*
        @Override
        public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float r, float g, float b, float a) {
                this.root.render(poseStack, buffer, packedLight, packedOverlay, r, g, b, a);
        }
        */
        //?}
}
<template>
    <div :style="{       
            width: '100%',
            height: tH + 'px',
            gridRowEnd: gap}"
            @click='boardDetail(image)'
            v-b-modal.modal-2>
        <img id='imageCardImage' :src="image.urls.small" style="borderRadius: 10px" width="100%"/>
        <p id='imageCardText'>{{image.description}}</p>
    </div>
</template>

<script>
    //import boardDetail from '@/components/Board/BoardDetail';
    export default {
        components:{
            //boardDetail
        },
        props: {
            image: {
            type: Object,
            required: true
            }
        },
        data: () => ({
            gap: null,
            tH: null
        }),

        created() {
            this.tH = Math.round(this.image.height / (this.image.width / 200)) + 20
            const gap = Math.round(this.tH / 10)
            this.gap = `span ${gap}`
        },
        methods:{
            boardDetail(image) {
                //this.$router.push({name: 'boarddetail', query: {image: image}});
                this.$emit(image);
            }
        }
    }
</script>

<style>
    #imageCardImage:hover{
        filter: brightness(50%);
    }
    #imageCardText{
        margin:0;
        font-family: 'NEXON Lv1 Gothic OTF Bold';
        display: block;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
        font-size: 7px;
    }
</style>
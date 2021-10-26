<template>
    <div :style="{       
            width: '100%',
            height: tH + 'px',
            gridRowEnd: gap,
            backgroundColor: 'gray',
            borderRadius: '10px'}">
        <img :src="image.urls.small" style="borderRadius: 10px"/>
    </div>
</template>

<script>
    export default {
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
            this.tH = Math.round(this.image.height / (this.image.width / 400))
            const gap = Math.round(this.tH / 10)
            this.gap = `span ${gap}`
        }
    }
</script>

<style>
</style>
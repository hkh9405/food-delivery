<template>

    <v-data-table
        :headers="headers"
        :items="menu"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'MenuView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "prodId", value: "prodId" },
                { text: "prodNm", value: "prodNm" },
                { text: "prodPrice", value: "prodPrice" },
                { text: "qty", value: "qty" },
            ],
            menu : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/menus'))

            temp.data._embedded.menus.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.menu = temp.data._embedded.menus;
        },
        methods: {
        }
    }
</script>


<template>

    <v-data-table
        :headers="headers"
        :items="orderDtl"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'OrderDtlView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "orderId", value: "orderId" },
                { text: "custId", value: "custId" },
                { text: "custAddr", value: "custAddr" },
                { text: "custTel", value: "custTel" },
                { text: "orderInfo", value: "orderInfo" },
                { text: "totPrice", value: "totPrice" },
                { text: "status", value: "status" },
            ],
            orderDtl : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/orderDtls'))

            temp.data._embedded.orderDtls.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.orderDtl = temp.data._embedded.orderDtls;
        },
        methods: {
        }
    }
</script>


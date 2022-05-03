<template>
  <div>
    <v-table></v-table>
    <v-dialog></v-dialog>
  </div>
</template>

<script>
import table from "../../../components/table";
import dialog from "../../../components/dialog";
export default {
  name: "index",
  components:{
    'v-dialog':dialog,
    'v-table':table
  }
}
</script>

<style scoped>

</style>

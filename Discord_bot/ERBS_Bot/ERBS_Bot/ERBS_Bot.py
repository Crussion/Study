import discord, requests
from Data import *

class ERBS(discord.Client):
    global icon_link
    global icon_dict
    global bot_icon

    async def on_ready(self):
        print('Logged on as', self.user)
        self.bot_icon = "https://github.com/Crussion/Study/blob/main/Discord_bot/ERBS_Bot/ERBS_Bot/res/bser-logo-bot.png?raw=true"
        await self.get_channel(857109283790520352).send('```' + "봇이 켜졌습니다." + '```')

    async def on_message(self, message):
        # don't respond to ourselves
        if message.author == self.user:
            return

        if message.content.lower().startswith('!nomal') | (message.content.split(' ')[0].lower() == '!n'):
            print('normal')
            await self.mk_send(message, 'n')

        if message.content.lower().startswith('!rank') | (message.content.split(' ')[0].lower() == '!r'):
            print('rank')
            await self.mk_send(message, 'r')

        if ((message.content.lower().split(' ')[0] == '!status') | (message.content.split(' ')[0].lower() == '!s')):
            print('status')
            await self.mk_send(message, 's')

        if ((message.content.lower().split(' ')[0] == '!help') | (message.content.lower().split(' ')[0] == '!h')):
            embed=discord.Embed(title=" ", color=0x44ff00)
            embed.set_author(name="Commend List", icon_url=self.bot_icon)
            embed.add_field(name="User Stat", value="!stat/!s - 유저의 기본 전적을 나타냅니다. (Detail - !stat/!s h)", inline=True)

    async def mk_send(self, msg, mode = 'n'):
        #!stat
        if(mode == 's'):
            try:
                if(msg.content.split(' ')[1].lower() == 'h'):
                    await msg.channel.send('```!stat/!s NickName Season(0 = nomar, 1 = season 1, 2 = free 2, 3 = season 2) TeamMode(solo, duo, trio / 1, 2, 3)```')
                    return
                nickname = msg.content.split(' ')[1]
            except:
                await msg.channel.send('```닉네임을 입력해 주세요.```')
                return

            try:
                season = msg.content.split(' ')[2]
                if((season == '0') | (season == '1') | (season == '2') | (season == '3')):
                    pass
                else:
                    await msg.channel.send('```시즌을 입력해 주세요.(0 = nomar, 1 = season 1, 2 = free 2, 3 = season 2)```')
                    return
            except:
                await msg.channel.send('```시즌을 입력해 주세요.(0 = nomar, 1 = season 1, 2 = free 2, 3 = season 2)```')
                return
            try:
                teamMod = msg.content.split(' ')[3].lower()
                if((teamMod == 'solo') | (teamMod == '1')):
                    t_mode = '솔로'
                elif((teamMod == 'duo') | (teamMod == '2')):
                    t_mode = '듀오'
                elif((teamMod == 'trio') | (teamMod == '3')):
                    t_mode = '스쿼드'
                else:
                    await msg.channel.send('```모드를 입력해 주세요.(solo, duo, trio / 1, 2, 3)```')
                    return
            except:
                await msg.channel.send('```모드를 입력해 주세요.(solo, duo, trio / 1, 2, 3)```')
                return
        #!normal, !rank
        else:
            try:
                if(msg.content.split(' ')[1].lower() == 'h'):
                    await msg.channel.send('```!normal(rank)/!n(r) NickName TeamMode(solo, duo, trio / 1, 2, 3)```')
                    return
                nickname = msg.content.split(' ')[1]
            except:
                await msg.channel.send('```닉네임을 입력해 주세요.```')
                return
            try:
                teamMod = msg.content.split(' ')[2].lower()
                if((teamMod == 'solo') | (teamMod == 'duo') | (teamMod == 'trio') | (teamMod == '1') | (teamMod == '2') | (teamMod == '3')):
                    pass
                else:
                    await msg.channel.send('```모드를 입력해 주세요.(solo, duo, trio / 1, 2, 3)```')
                    return
            except:
                await msg.channel.send('```모드를 입력해 주세요.(solo, duo, trio / 1, 2, 3)```')
                return
        wait_message = await msg.channel.send('```Wait a second...```')
        data = Data(nickname)
        print("code: ", data.code)
        if(data.code == 404):
            await wait_message.delete()
            await msg.channel.send('```존재하지 않는 닉네임입니다.```')
            return
        #!normal
        if(mode == 'n'): 
            id_list = data.get_Normal_Game(teamMod)
            s = ''
            if(len(id_list) != 0):
                for n in id_list:
                    s = s + str(n) + '\n'
            else:
                s = '매치가 존재하지 않습니다.'
            await wait_message.delete()
            await msg.channel.send(s)
        #!rank
        elif(mode == 'r'): 
            id_list = data.get_Rank_Game(teamMod)
            s = ''
            if(len(id_list) != 0):
                for n in id_list:
                    s = s + str(n) + '\n'
            else:
                s = '매치가 존재하지 않습니다.'
            await wait_message.delete()
            await msg.channel.send(s)
        #!stat
        elif(mode == 's'):
            data.set_Season(season)
            stat_json = data.get_Stat(teamMod)
            if(stat_json == None):
                await wait_message.delete()
                await msg.channel.send("```전적이 존재하지 않습니다.```")
                return
            self.icon_link = data.icon_link

            embed=discord.Embed(title=nickname, url="https://dak.gg/bser/players/{0}?hl=ko-KR".format(nickname), description="{0} - most {1}".format(t_mode, data.icon_dict[data.char_num]), color=0x44ff00)
            embed.set_author(name="User Stat", icon_url=self.bot_icon)
            embed.set_thumbnail(url=self.icon_link)
            
            embed.add_field(name="MMR", value=str(stat_json['mmr']), inline=False)
            embed.add_field(name="게임 수", value=str(stat_json['totalGames']), inline=True)
            embed.add_field(name="승리 수", value=str(stat_json['totalWins']), inline=True)
            embed.add_field(name="승률", value=str(round(stat_json['totalWins'] / stat_json['totalGames'] * 100, 1)), inline=True)
            embed.add_field(name="평균 순위", value=str(stat_json['averageRank']), inline=True)
            embed.add_field(name="평균 킬", value=str(stat_json['averageKills']), inline=True)
            embed.add_field(name="평균 어시스트", value=str(stat_json['averageAssistants']), inline=True)
            embed.add_field(name="평균 동물 킬", value=str(stat_json['averageHunts']), inline=True)
            embed.set_footer(text="Detail - Click to Nickname", icon_url=self.bot_icon)

            await wait_message.delete()
            await msg.channel.send(embed=embed)
        else: 
            id_list = data.get_Normal_Game(teamMod)
            s = ''
            if(len(id_list) != 0):
                for n in id_list:
                    s = s + str(n) + '\n'
            else:
                s = '매치가 존재하지 않습니다.'
            await wait_message.delete()
            await msg.channel.send(s)

client = ERBS()
data = Data()

torken = data.Discord_torken
client.run(torken)
